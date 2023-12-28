package com.example.uscitizenship.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserStateDataStore(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("userStateOrDistrict")
        private val USER_STATE_KEY = stringPreferencesKey("user_state_or_district")
    }

    val getUserState: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[USER_STATE_KEY] ?: ""
    }

    suspend fun saveUserState(state: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_STATE_KEY] = state
        }
    }
}
