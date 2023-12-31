package com.dpappdev.uscitizenship.ui

import com.dpappdev.uscitizenship.data.Question

data class AllQuestionsUiState(
    val questions: List<Question> = listOf(),
)