package com.dpappdev.uscitizenship.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AllQuestionsViewModelFactory(
    private val testYear: String,
    private val userStateOrDistrict: String,
    private val usRepresentative: String,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AllQuestionsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AllQuestionsViewModel(testYear, userStateOrDistrict, usRepresentative) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
