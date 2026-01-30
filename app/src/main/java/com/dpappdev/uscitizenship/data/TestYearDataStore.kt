package com.dpappdev.uscitizenship.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TestYearDataStore(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("testYear")
        private val TEST_YEAR_KEY = stringPreferencesKey("test_year")
    }

    val getTestYearFlow: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[TEST_YEAR_KEY] ?: ""
    }

    suspend fun saveTestYear(state: String) {
        context.dataStore.edit { preferences ->
            preferences[TEST_YEAR_KEY] = state
        }
    }
}