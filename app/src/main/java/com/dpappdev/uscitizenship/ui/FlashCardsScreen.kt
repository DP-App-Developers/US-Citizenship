package com.dpappdev.uscitizenship.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dpappdev.uscitizenship.R
import com.dpappdev.uscitizenship.data.Question
import com.dpappdev.uscitizenship.ui.theme.USCitizenshipTheme

@Composable
fun FlashCardsScreen(
    questions: List<Question>,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        var questionCount by rememberSaveable { mutableIntStateOf(1) }
        var expanded by rememberSaveable { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
        ) {
            Text(
                text = "Question $questionCount / 100",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            ElevatedCard(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(bottom = 100.dp)
                    .clickable(enabled = !expanded) { expanded = true }, // card is not clickable when it's expanded
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = questions[questionCount - 1].question,
                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.height(40.dp))

                    if (!expanded) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_keyboard_arrow_down_24),
                            contentDescription = "reveal answer",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    } else {
                        val bullet = "\u2022"
                        questions[questionCount - 1].answer.forEach {
                            Text(
                                text = "$bullet $it",
                                fontSize = 20.sp
                            )
                        }
                    }
                }
            }
        }

        Button(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomStart),
            onClick = {
                expanded = false
                if (questionCount == 1) {
                    questionCount = 100
                } else {
                    questionCount--
                }
            },
        ) {
            Text(text = "Previous")
        }

        Button(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            onClick = {
                expanded = false
                if (questionCount == 100) {
                    questionCount = 1
                } else {
                    questionCount++
                }
            },
        ) {
            Text(text = "Next")
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