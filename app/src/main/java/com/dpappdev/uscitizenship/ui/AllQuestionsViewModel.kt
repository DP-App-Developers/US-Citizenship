package com.dpappdev.uscitizenship.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dpappdev.uscitizenship.data.AllQuestionsLocalDataSource
import com.dpappdev.uscitizenship.data.AllQuestionsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AllQuestionsViewModel(
    testYear: String,
    userStateOrDistrict: String,
    usRepresentative: String,
) : ViewModel() {
    private val _uiState = MutableStateFlow(AllQuestionsUiState())
    val uiState: StateFlow<AllQuestionsUiState> = _uiState.asStateFlow()

    init {
        reload(testYear, userStateOrDistrict, usRepresentative)
    }

    fun reload(testYear: String, userStateOrDistrict: String, usRepresentative: String) {
        if (testYear == "loading" || userStateOrDistrict == "loading" || usRepresentative == "loading") return

        viewModelScope.launch {
            AllQuestionsRepository(AllQuestionsLocalDataSource(testYear, userStateOrDistrict, usRepresentative)).allQuestions.collect {
                _uiState.value = AllQuestionsUiState(
                    questions = it
                )
            }
        }
    }
}