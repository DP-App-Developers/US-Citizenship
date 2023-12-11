package com.example.uscitizenship.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uscitizenship.data.Question
import com.example.uscitizenship.ui.theme.USCitizenshipTheme

@Composable
fun AllQuestionsScreen(
    questions: List<Question>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        questions.forEach {
            Text(
                text = it.question
            )
            Divider(thickness = 1.dp, color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AllQuestionsPreview() {
    USCitizenshipTheme {
        AllQuestionsScreen(
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