package com.dpappdev.uscitizenship.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dpappdev.uscitizenship.data.AllQuestionsLocalDataSource
import com.dpappdev.uscitizenship.data.AllQuestionsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AllQuestionsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AllQuestionsUiState())
    val uiState: StateFlow<AllQuestionsUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            AllQuestionsRepository(AllQuestionsLocalDataSource()).allQuestions.collect {
                _uiState.value = AllQuestionsUiState(
                    questions = it
                )
            }
        }
    }
}