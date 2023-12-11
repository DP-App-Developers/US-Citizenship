package com.example.uscitizenship.ui

import com.example.uscitizenship.data.Question

data class AllQuestionsUiState(
    val questions: List<Question> = listOf(),
)