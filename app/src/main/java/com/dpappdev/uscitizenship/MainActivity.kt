package com.dpappdev.uscitizenship

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.dpappdev.uscitizenship.ads.AdViewModel
import com.dpappdev.uscitizenship.billing.BillingManager
import com.dpappdev.uscitizenship.data.FlashCardsShuffleDataStore
import com.dpappdev.uscitizenship.notifications.NotificationHelper
import com.dpappdev.uscitizenship.notifications.NotificationScheduler
import com.dpappdev.uscitizenship.ui.theme.USCitizenshipTheme
import com.google.android.gms.ads.MobileAds
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.Locale

class MainActivity : ComponentActivity() {
    private lateinit var textToSpeech: TextToSpeech
    private lateinit var billingManager: BillingManager
    private val adViewModel: AdViewModel by viewModels()
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    // Notification permission launcher
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Permission granted, schedule notifications
            scheduleNotifications()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        // Initialize Firebase Analytics
        firebaseAnalytics = Firebase.analytics

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

        // Initialize notifications
        initializeNotifications()

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

    private fun initializeNotifications() {
        // Create notification channel
        NotificationHelper.createNotificationChannel(this)

        // Check and request notification permission for Android 13+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            when {
                ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED -> {
                    // Permission already granted, schedule notifications
                    scheduleNotifications()
                }
                else -> {
                    // Request permission
                    requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                }
            }
        } else {
            // For Android 12 and below, no runtime permission needed
            scheduleNotifications()
        }
    }

    private fun scheduleNotifications() {
        NotificationScheduler.scheduleWeeklyNotification(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        textToSpeech.shutdown()
        billingManager.endConnection()
    }
}
