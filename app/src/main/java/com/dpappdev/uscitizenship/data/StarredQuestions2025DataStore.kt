package com.dpappdev.uscitizenship.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StarredQuestions2025DataStore(private val context: Context) : StarredQuestionsDataStoreInterface {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("starredQuestions2025")
        private val STARRED_QUESTIONS_KEY = stringPreferencesKey("starred_questions_2025")
    }

    override val getStarredQuestions: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[STARRED_QUESTIONS_KEY] ?: ""
    }

    override suspend fun saveStarredQuestions(state: String) {
        context.dataStore.edit { preferences ->
            preferences[STARRED_QUESTIONS_KEY] = state
        }
    }
}