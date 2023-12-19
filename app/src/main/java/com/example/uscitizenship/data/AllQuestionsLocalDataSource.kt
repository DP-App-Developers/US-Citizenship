package com.example.uscitizenship.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AllQuestionsLocalDataSource() {
    val allQuestions: Flow<List<Question>> = flow {
        emit(
            listOf(
                Question(
                    question = "1. What is the supreme law of the land?",
                    answer = listOf("the Constitution"),
                ),
                Question(
                    question = "2. What does the Constitution do?",
                    answer = listOf(
                        "sets up the government",
                        "defines the government",
                        "protects basic rights of Americans"
                    ),
                ),
            )
        )
    }
}