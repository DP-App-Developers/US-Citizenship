package com.dpappdev.uscitizenship.billing

import android.app.Activity
import android.content.Context
import android.util.Log
import com.android.billingclient.api.*
import com.dpappdev.uscitizenship.data.PremiumStatusDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class BillingManager(private val context: Context) : PurchasesUpdatedListener {
    
    private var billingClient: BillingClient? = null
    private val premiumStatusDataStore = PremiumStatusDataStore(context)
    private val _isPremium = MutableStateFlow(false)
    val isPremium: StateFlow<Boolean> = _isPremium.asStateFlow()
    
    private val _purchaseState = MutableStateFlow<PurchaseState>(PurchaseState.Idle)
    val purchaseState: StateFlow<PurchaseState> = _purchaseState.asStateFlow()
    
    companion object {
        private const val TAG = "BillingManager"
        const val PREMIUM_PRODUCT_ID = "us_citizenship_test_premium_features"
    }
    
    init {
        // Load cached premium status first (for offline support)
        CoroutineScope(Dispatchers.IO).launch {
            val cachedStatus = premiumStatusDataStore.isPremium.first()
            _isPremium.value = cachedStatus
            Log.d(TAG, "Loaded cached premium status: $cachedStatus")
        }
        setupBillingClient()
    }
    
    private fun setupBillingClient() {
        billingClient = BillingClient.newBuilder(context)
            .setListener(this)
            .enablePendingPurchases(
                PendingPurchasesParams.newBuilder().enableOneTimeProducts().build()
            )
            .enableAutoServiceReconnection()
            .build()
        
        billingClient?.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(billingResult: BillingResult) {
                if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                    Log.d(TAG, "Billing client connected")
                    queryPurchases()
                } else {
                    Log.e(TAG, "Billing setup failed: ${billingResult.debugMessage}")
                }
            }
            
            override fun onBillingServiceDisconnected() {
                Log.d(TAG, "Billing service disconnected")
                // Try to reconnect
                setupBillingClient()
            }
        })
    }
    
    private fun queryPurchases() {
        billingClient?.queryPurchasesAsync(
            QueryPurchasesParams.newBuilder()
                .setProductType(BillingClient.ProductType.INAPP)
                .build()
        ) { billingResult, purchases ->
            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                handlePurchases(purchases)
            } else {
                Log.e(TAG, "Query purchases failed: ${billingResult.debugMessage}")
            }
        }
    }
    
    private fun handlePurchases(purchases: List<Purchase>) {
        var hasPremium = false
        
        for (purchase in purchases) {
            if (purchase.products.contains(PREMIUM_PRODUCT_ID) && 
                purchase.purchaseState == Purchase.PurchaseState.PURCHASED) {
                
                if (!purchase.isAcknowledged) {
                    acknowledgePurchase(purchase)
                }
                hasPremium = true
            }
        }
        
        _isPremium.value = hasPremium
        Log.d(TAG, "Premium status updated: $hasPremium")
        
        // Cache the premium status for offline support
        CoroutineScope(Dispatchers.IO).launch {
            premiumStatusDataStore.savePremiumStatus(hasPremium)
            Log.d(TAG, "Cached premium status: $hasPremium")
        }
    }
    
    private fun acknowledgePurchase(purchase: Purchase) {
        val acknowledgePurchaseParams = AcknowledgePurchaseParams.newBuilder()
            .setPurchaseToken(purchase.purchaseToken)
            .build()
        
        billingClient?.acknowledgePurchase(acknowledgePurchaseParams) { billingResult ->
            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                Log.d(TAG, "Purchase acknowledged")
            } else {
                Log.e(TAG, "Failed to acknowledge purchase: ${billingResult.debugMessage}")
            }
        }
    }
    
    fun launchPurchaseFlow(activity: Activity) {
        _purchaseState.value = PurchaseState.Loading
        
        val queryProductDetailsParams = QueryProductDetailsParams.newBuilder()
            .setProductList(
                listOf(
                    QueryProductDetailsParams.Product.newBuilder()
                        .setProductId(PREMIUM_PRODUCT_ID)
                        .setProductType(BillingClient.ProductType.INAPP)
                        .build()
                )
            )
            .build()
        
        billingClient?.queryProductDetailsAsync(queryProductDetailsParams) { billingResult, queryProductDetailsResult ->
            val productDetailsList = queryProductDetailsResult.productDetailsList
            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK && productDetailsList.isNotEmpty()) {
                val productDetails = productDetailsList.first()
                
                val productDetailsParamsList = listOf(
                    BillingFlowParams.ProductDetailsParams.newBuilder()
                        .setProductDetails(productDetails)
                        .build()
                )
                
                val billingFlowParams = BillingFlowParams.newBuilder()
                    .setProductDetailsParamsList(productDetailsParamsList)
                    .build()
                
                billingClient?.launchBillingFlow(activity, billingFlowParams)
            } else {
                Log.e(TAG, "Failed to query product details: ${billingResult.debugMessage}")
                _purchaseState.value = PurchaseState.Error("Failed to load product details")
            }
        }
    }
    
    override fun onPurchasesUpdated(billingResult: BillingResult, purchases: List<Purchase>?) {
        when (billingResult.responseCode) {
            BillingClient.BillingResponseCode.OK -> {
                if (purchases != null) {
                    handlePurchases(purchases)
                    _purchaseState.value = PurchaseState.Success
                }
            }
            BillingClient.BillingResponseCode.USER_CANCELED -> {
                Log.d(TAG, "User canceled purchase")
                _purchaseState.value = PurchaseState.Cancelled
            }
            else -> {
                Log.e(TAG, "Purchase failed: ${billingResult.debugMessage}")
                _purchaseState.value = PurchaseState.Error(billingResult.debugMessage)
            }
        }
    }
    
    fun endConnection() {
        billingClient?.endConnection()
    }
    
    sealed class PurchaseState {
        object Idle : PurchaseState()
        object Loading : PurchaseState()
        object Success : PurchaseState()
        object Cancelled : PurchaseState()
        data class Error(val message: String) : PurchaseState()
    }
}
