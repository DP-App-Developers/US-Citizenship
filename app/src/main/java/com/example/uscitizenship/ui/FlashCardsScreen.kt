package com.example.uscitizenship.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uscitizenship.data.Question
import com.example.uscitizenship.ui.theme.USCitizenshipTheme

@Composable
fun FlashCardsScreen(
    questions: List<Question>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        var questionCount = 1
        Text("Card $questionCount / 100")

        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clickable {  }
        ) {
            Text(questions[questionCount-1].question)
        }

        Row(
            modifier = Modifier
        ) {
            Button(
                modifier = Modifier,
                onClick = {}
            ) {
                Text("Previous")
            }
            Button(
                modifier = Modifier,
                onClick = {}
            ) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlashCardsPreview() {
    USCitizenshipTheme {
        FlashCardsScreen(
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