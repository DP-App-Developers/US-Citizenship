package com.dpappdev.uscitizenship.analytics

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

object AnalyticsHelper {
    private val analytics: FirebaseAnalytics by lazy {
        Firebase.analytics
    }

    // Event names
    private const val EVENT_TEST_YEAR_SELECTED = "test_year_selected"
    private const val EVENT_STATE_SELECTED = "state_selected"
    private const val EVENT_QUESTION_STARRED = "question_starred"
    private const val EVENT_QUESTION_UNSTARRED = "question_unstarred"
    private const val EVENT_FLASHCARD_NAVIGATION = "flashcard_navigation"

    // Parameter names
    private const val PARAM_TEST_YEAR = "test_year"
    private const val PARAM_STATE = "state"
    private const val PARAM_QUESTION_NUMBER = "question_number"
    private const val PARAM_NAVIGATION_DIRECTION = "direction"

    /**
     * Log when user selects a test year (2008 or 2025 Civics Test)
     */
    fun logTestYearSelected(testYear: String) {
        val bundle = Bundle().apply {
            putString(PARAM_TEST_YEAR, testYear)
        }
        analytics.logEvent(EVENT_TEST_YEAR_SELECTED, bundle)
    }

    /**
     * Log when user selects their state or district
     */
    fun logStateSelected(state: String) {
        val bundle = Bundle().apply {
            putString(PARAM_STATE, state)
        }
        analytics.logEvent(EVENT_STATE_SELECTED, bundle)
    }

    /**
     * Log when user stars a question
     */
    fun logQuestionStarred(questionNumber: Int) {
        val bundle = Bundle().apply {
            putInt(PARAM_QUESTION_NUMBER, questionNumber)
        }
        analytics.logEvent(EVENT_QUESTION_STARRED, bundle)
    }

    /**
     * Log when user unstars a question
     */
    fun logQuestionUnstarred(questionNumber: Int) {
        val bundle = Bundle().apply {
            putInt(PARAM_QUESTION_NUMBER, questionNumber)
        }
        analytics.logEvent(EVENT_QUESTION_UNSTARRED, bundle)
    }

    /**
     * Log flashcard navigation (Next or Previous button clicks)
     */
    fun logFlashcardNavigation(direction: String) {
        val bundle = Bundle().apply {
            putString(PARAM_NAVIGATION_DIRECTION, direction)
        }
        analytics.logEvent(EVENT_FLASHCARD_NAVIGATION, bundle)
    }
}
