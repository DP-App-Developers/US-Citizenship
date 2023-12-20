package com.example.uscitizenship.data

import com.example.uscitizenship.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AllQuestionsLocalDataSource() {
    val allQuestions: Flow<List<Question>> = flow {
        emit(
            listOf(
                // 1
                Question(
                    question = "What is the supreme law of the land?",
                    answer = listOf(
                        "the Constitution"
                    ),
                ),
                // 2
                Question(
                    question = "What does the Constitution do?",
                    answer = listOf(
                        "sets up the government",
                        "defines the government",
                        "protects basic rights of Americans"
                    ),
                ),
                // 3
                Question(
                    question = "The idea of self-government is in the first three words of the Constitution. What are these words?",
                    answer = listOf(
                        "We the People"
                    ),
                ),
                // 4
                Question(
                    question = "What is an amendment?",
                    answer = listOf(
                        "a change (to the Constitution)",
                        "an addition (to the Constitution)"
                    ),
                ),
                // 5
                Question(
                    question = "What do we call the first ten amendments to the Constitution?",
                    answer = listOf(
                        "the Bill of Rights"
                    ),
                ),
                // 6
                Question(
                    question = "What is one right or freedom from the First Amendment?",
                    answer = listOf(
                        "speech",
                        "religion",
                        "assembly",
                        "press",
                        "petition the government"
                    ),
                ),
                // 7
                Question(
                    question = "How many amendments does the Constitution have?",
                    answer = listOf(
                        "twenty-seven (27)"
                    ),
                ),
                // 8
                Question(
                    question = "What did the Declaration of Independence do?",
                    answer = listOf(
                        "announced our independence (from Great Britain)",
                        "declared our independence (from Great Britain)",
                        "said that the United States is free (from Great Britain)"
                    ),
                ),
                // 9
                Question(
                    question = "What are two rights in the Declaration of Independence?",
                    answer = listOf(
                        "life",
                        "liberty",
                        "pursuit of happiness"
                    ),
                ),
                // 10
                Question(
                    question = "What is freedom of religion?",
                    answer = listOf(
                        "You can practice any religion, or not practice a religion."
                    ),
                ),
            )
        )
    }
}