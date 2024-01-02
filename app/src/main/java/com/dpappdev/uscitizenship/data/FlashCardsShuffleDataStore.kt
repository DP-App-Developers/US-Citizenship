package com.dpappdev.uscitizenship.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FlashCardsShuffleDataStore(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("flashCardsShuffleOn")
        private val US_REPRESENTATIVE_KEY = booleanPreferencesKey("flash_cards_shuffle_on")
    }

    val isShuffleOn: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[US_REPRESENTATIVE_KEY] ?: false
    }

    suspend fun saveShuffleOn(shuffleOn: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[US_REPRESENTATIVE_KEY] = shuffleOn
        }
    }
}