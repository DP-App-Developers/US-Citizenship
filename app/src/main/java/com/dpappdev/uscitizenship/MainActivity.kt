package com.dpappdev.uscitizenship

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.dpappdev.uscitizenship.ads.AdViewModel
import com.dpappdev.uscitizenship.billing.BillingManager
import com.dpappdev.uscitizenship.data.FlashCardsShuffleDataStore
import com.dpappdev.uscitizenship.ui.theme.USCitizenshipTheme
import com.google.android.gms.ads.MobileAds
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.Locale

class MainActivity : ComponentActivity() {
    private lateinit var textToSpeech: TextToSpeech
    private lateinit var billingManager: BillingManager
    private val adViewModel: AdViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        // Initialize Mobile Ads SDK
        MobileAds.initialize(this) { initializationStatus ->
            Log.d("MainActivity", "AdMob SDK initialized: ${initializationStatus.adapterStatusMap}")
        }
        
        // Set test device IDs for development (emulators are automatically test devices)
//        val testDeviceIds = listOf(
//            RequestConfiguration.TEST_DEVICE_HASHED_ID_EMULATOR
//        )
//        val requestConfiguration = RequestConfiguration.Builder()
//            .setTestDeviceIds(testDeviceIds)
//            .build()
//        MobileAds.setRequestConfiguration(requestConfiguration)

        textToSpeech = TextToSpeech(this) {
            // no-op
        }
        textToSpeech.language = Locale.US

        billingManager = BillingManager(this)
        
        // Reset shuffle to false on app start if user is not premium
        CoroutineScope(Dispatchers.IO).launch {
            val isPremium = billingManager.isPremium.first()
            if (!isPremium) {
                val shuffleDataStore = FlashCardsShuffleDataStore(this@MainActivity)
                shuffleDataStore.saveShuffleOn(false)
            }
        }

        setContent {
            USCitizenshipTheme {
                val isPremium by billingManager.isPremium.collectAsState()
                USCitizenApp(
                    textToSpeech = textToSpeech,
                    isPremium = isPremium,
                    billingManager = billingManager,
                    adManager = adViewModel.adManager
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        textToSpeech.shutdown()
        billingManager.endConnection()
    }
}
