package com.example.uscitizenship.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AllQuestionsLocalDataSource() {
    val allQuestions: Flow<List<Question>> = flow {
        emit(
            listOf(
                Question(
                    question = "1. What is the supreme law of the land?",
                    answer = listOf(),
                ),
                Question(
                    question = "2. What does the Constitution do?",
                    answer = listOf(),
                ),
            )
        )
    }
}