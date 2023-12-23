package com.example.uscitizenship.ui

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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uscitizenship.R
import com.example.uscitizenship.data.Question
import com.example.uscitizenship.ui.theme.USCitizenshipTheme

@Composable
fun FlashCardsScreen(
    questions: List<Question>,
    modifier: Modifier = Modifier,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        var questionCount by rememberSaveable { mutableIntStateOf(1) }
        var expanded by rememberSaveable { mutableStateOf(false) }

        Column(
            modifier = modifier
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
                            painter = painterResource(id = R.drawable.baseline_expand_circle_down_24),
                            contentDescription = "reveal answer",
                            tint = Color.DarkGray,
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

        ExtendedFloatingActionButton(
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

        ExtendedFloatingActionButton(
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
                    question = "1. What is the supreme law of the land? On the civics test, some answers may change because of federal or state elections, certain judicial appointments, or due to statutory changes or updates. You must answer the question with the name of the official serving at the time of your naturalization interview. On this page, you can find the answers that may have changed on the civics test to the 2008 version of the test On the civics test, some answers may change because of federal or state elections, certain judicial appointments, or due to statutory changes or updates. You must answer the question with the name of the official serving at the time of your naturalization interview. On this page, you can find the answers that may have changed on the civics test to the 2008 version of the test On the civics test, some answers may change because of federal or state elections, certain judicial appointments, or due to statutory changes or updates. You must answer the question with the name of the official serving at the time of your naturalization interview. On this page, you can find the answers that may have changed on the civics test to the 2008 version of the test",
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