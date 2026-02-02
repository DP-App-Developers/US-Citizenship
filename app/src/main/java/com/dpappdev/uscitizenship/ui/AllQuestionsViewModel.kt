package com.dpappdev.uscitizenship.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dpappdev.uscitizenship.data.AllQuestionsLocalDataSource
import com.dpappdev.uscitizenship.data.AllQuestionsRepository
import com.dpappdev.uscitizenship.data.Question
import com.dpappdev.uscitizenship.data.getGovernor
import com.dpappdev.uscitizenship.data.getSenators
import com.dpappdev.uscitizenship.data.getStateCapital
import kotlinx.coroutines.Dispatchers
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

        viewModelScope.launch(Dispatchers.IO) {
            AllQuestionsRepository(AllQuestionsLocalDataSource()).allQuestions.collect {
                _uiState.value = AllQuestionsUiState(
                    questions =
                        if (testYear == "2008 Civics Test") consolidateAnswers(userStateOrDistrict, usRepresentative, it)
                        else listOf()//change this
                )
            }
        }
    }

    fun consolidateAnswers(
        userStateOrDistrict: String,
        usRepresentative: String,
        questions: List<Question>,
    ): List<Question> {
        if (questions.isEmpty()) return questions

        val stateGovernor = getGovernor(userStateOrDistrict)
        val stateCapital = getStateCapital(userStateOrDistrict)
        val stateSenators = getSenators(userStateOrDistrict)
        if (stateSenators.isNotEmpty()) {
            questions[19].answer = stateSenators
        }
        if (usRepresentative.isNotEmpty()) {
            questions[22].answer = listOf(usRepresentative)
        }
        if (!stateGovernor.isNullOrEmpty()) {
            questions[42].answer = listOf(stateGovernor)
        }
        if (!stateCapital.isNullOrEmpty()) {
            questions[43].answer = listOf(stateCapital)
        }
        return questions
    }
}