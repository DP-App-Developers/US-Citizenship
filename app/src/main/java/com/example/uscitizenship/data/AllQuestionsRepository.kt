package com.example.uscitizenship.data

import kotlinx.coroutines.flow.Flow

class AllQuestionsRepository(
    allQuestionsLocalDataSource: AllQuestionsLocalDataSource
) {
    val allQuestions: Flow<List<Question>> = allQuestionsLocalDataSource.allQuestions
}