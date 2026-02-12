package com.dpappdev.uscitizenship.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.premiumDataStore: DataStore<Preferences> by preferencesDataStore(name = "premium_status")

class PremiumStatusDataStore(private val context: Context) {
    
    companion object {
        private val PREMIUM_STATUS_KEY = booleanPreferencesKey("is_premium")
    }
    
    val isPremium: Flow<Boolean> = context.premiumDataStore.data.map { preferences ->
        preferences[PREMIUM_STATUS_KEY] ?: false
    }
    
    suspend fun savePremiumStatus(isPremium: Boolean) {
        context.premiumDataStore.edit { preferences ->
            preferences[PREMIUM_STATUS_KEY] = isPremium
        }
    }
}
