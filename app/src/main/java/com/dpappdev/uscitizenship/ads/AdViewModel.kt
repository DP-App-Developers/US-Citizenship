package com.dpappdev.uscitizenship.ads

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.dpappdev.uscitizenship.data.PremiumStatusDataStore
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AdViewModel(application: Application) : AndroidViewModel(application) {
    val adManager = AdManager(application.applicationContext)
    private val premiumStatusDataStore = PremiumStatusDataStore(application.applicationContext)
    
    val isPremium: StateFlow<Boolean> = premiumStatusDataStore.isPremium.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )
    
    init {
        // Only preload rewarded ad if user is not premium
        viewModelScope.launch {
            isPremium.collect { premium ->
                if (!premium) {
                    adManager.loadRewardedAd()
                }
            }
        }
    }
}
