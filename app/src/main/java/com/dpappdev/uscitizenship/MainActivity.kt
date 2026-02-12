package com.dpappdev.uscitizenship

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.dpappdev.uscitizenship.billing.BillingManager
import com.dpappdev.uscitizenship.ui.theme.USCitizenshipTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    private lateinit var textToSpeech: TextToSpeech
    private lateinit var billingManager: BillingManager

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        textToSpeech = TextToSpeech(this) {
            // no-op
        }
        textToSpeech.language = Locale.US

        billingManager = BillingManager(this)

        setContent {
            USCitizenshipTheme {
                val isPremium by billingManager.isPremium.collectAsState()
                USCitizenApp(
                    textToSpeech = textToSpeech,
                    isPremium = isPremium,
                    billingManager = billingManager
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
