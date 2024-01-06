package com.dpappdev.uscitizenship

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.dpappdev.uscitizenship.ui.theme.USCitizenshipTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    private lateinit var textToSpeech: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        textToSpeech = TextToSpeech(this) {
            // no-op
        }
        textToSpeech.language = Locale.US

        setContent {
            USCitizenshipTheme {
                USCitizenApp(textToSpeech)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        textToSpeech.shutdown()
    }
}
