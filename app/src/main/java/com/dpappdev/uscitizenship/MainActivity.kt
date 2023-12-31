package com.dpappdev.uscitizenship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dpappdev.uscitizenship.ui.theme.USCitizenshipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            USCitizenshipTheme {
                USCitizenApp()
            }
        }
    }
}
