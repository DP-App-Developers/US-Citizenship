package com.dpappdev.uscitizenship.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UsRepresentativeDataStore(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("usRepresentative")
        private val US_REPRESENTATIVE_KEY = stringPreferencesKey("us_representative")
    }

    val getUsRepresentative: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[US_REPRESENTATIVE_KEY] ?: ""
    }

    suspend fun saveUsRepresentative(state: String) {
        context.dataStore.edit { preferences ->
            preferences[US_REPRESENTATIVE_KEY] = state
        }
    }
}