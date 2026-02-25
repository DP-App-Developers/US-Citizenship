package com.dpappdev.uscitizenship.ads

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AdManager(private val context: Context) {
    
    private var rewardedAd: RewardedAd? = null
    private var isLoading = false
    
    private val _isAdReady = MutableStateFlow(false)
    val isAdReady: StateFlow<Boolean> = _isAdReady.asStateFlow()
    
    companion object {
        private const val TAG = "AdManager"
        // Grant 1 hour of premium access (3600000 milliseconds)
        const val REWARDED_AD_TIME = 3000L
        // Test ad unit ID for rewarded ads "ca-app-pub-3940256099942544/5224354917"
        // Replace with your actual ad unit ID in production
        private const val AD_UNIT_ID = "ca-app-pub-3940256099942544/5224354917"
    }
    
    fun loadRewardedAd() {
        if (isLoading || rewardedAd != null) {
            Log.d(TAG, "Ad is already loading or loaded. isLoading=$isLoading, rewardedAd=$rewardedAd")
            return
        }
        
        Log.d(TAG, "Starting to load rewarded ad...")
        isLoading = true
        val adRequest = AdRequest.Builder().build()
        
        RewardedAd.load(
            context,
            AD_UNIT_ID,
            adRequest,
            object : RewardedAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.e(TAG, "Ad failed to load - Code: ${adError.code}, Message: ${adError.message}, Domain: ${adError.domain}")
                    rewardedAd = null
                    isLoading = false
                    _isAdReady.value = false
                }
                
                override fun onAdLoaded(ad: RewardedAd) {
                    Log.d(TAG, "Ad loaded successfully!")
                    rewardedAd = ad
                    isLoading = false
                    _isAdReady.value = true
                }
            }
        )
    }
    
    fun showRewardedAd(
        activity: Activity,
        onUserEarnedReward: () -> Unit,
        onAdDismissed: () -> Unit,
        onAdFailedToShow: (String) -> Unit
    ) {
        val ad = rewardedAd
        if (ad == null) {
            Log.e(TAG, "Rewarded ad is not ready yet")
            onAdFailedToShow("Ad is not ready yet. Please try again.")
            return
        }
        
        ad.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
                Log.d(TAG, "Ad dismissed")
                rewardedAd = null
                _isAdReady.value = false
                onAdDismissed()
                // Preload the next ad
                loadRewardedAd()
            }
            
            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                Log.e(TAG, "Ad failed to show: ${adError.message}")
                rewardedAd = null
                _isAdReady.value = false
                onAdFailedToShow(adError.message)
            }
            
            override fun onAdShowedFullScreenContent() {
                Log.d(TAG, "Ad showed fullscreen content")
            }
        }
        
        ad.show(activity) { rewardItem ->
            Log.d(TAG, "User earned reward: ${rewardItem.amount} ${rewardItem.type}")
            onUserEarnedReward()
        }
    }
    
}
