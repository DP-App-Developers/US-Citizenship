package com.example.uscitizenship.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uscitizenship.data.Question
import com.example.uscitizenship.ui.theme.USCitizenshipTheme

@Composable
fun AllQuestionsScreen(
    questions: List<Question>,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val borderPadding = 18.dp
        val textSize = 16.sp

        var questionCount = 1
        questions.forEach {
            Row(modifier = Modifier.padding(borderPadding)) {
                Text(
                    text = "$questionCount.",
                    modifier = Modifier.padding(end = 8.dp)
                )

                Column {
                    Text(
                        text = it.question,
                        fontSize = textSize,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    val bullet = "\u2022"
                    it.answer.forEach {
                        Text(
                            text = "$bullet $it",
                            fontSize = textSize,
                        )
                    }
                }
            }
            Divider(thickness = 1.dp, color = Color.Black)
            questionCount++
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
                    question = "What is the supreme law of the land?",
                    answer = listOf("the Constitution"),
                ),
                Question(
                    question = "What does the Constitution do?",
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