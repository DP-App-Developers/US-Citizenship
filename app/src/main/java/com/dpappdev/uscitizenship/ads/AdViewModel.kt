package com.dpappdev.uscitizenship.ads

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class AdViewModel(application: Application) : AndroidViewModel(application) {
    val adManager = AdManager(application.applicationContext)
    
    init {
        // Preload rewarded ad when ViewModel is created
        adManager.loadRewardedAd()
    }
}
