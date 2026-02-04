package com.dpappdev.uscitizenship.data

import kotlinx.coroutines.flow.Flow

interface StarredQuestionsDataStore {
    val getStarredQuestions: Flow<String>

    suspend fun saveStarredQuestions(state: String)
}