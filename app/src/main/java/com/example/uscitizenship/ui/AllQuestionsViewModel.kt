package com.example.uscitizenship.ui

import androidx.lifecycle.ViewModel
import com.example.uscitizenship.data.Question
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AllQuestionsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AllQuestionsUiState(questions = getAllQuestions()))
    val uiState: StateFlow<AllQuestionsUiState> = _uiState.asStateFlow()

    private fun getAllQuestions(): List<Question> {
        return listOf(
            Question(
                question = "1. What is the supreme law of the land?",
                answer = listOf(),
            ),
            Question(
                question = "2. What does the Constitution do?",
                answer = listOf(),
            ),
        )
    }
}