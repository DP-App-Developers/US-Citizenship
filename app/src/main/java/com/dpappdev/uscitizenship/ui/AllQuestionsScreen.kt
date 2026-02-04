package com.dpappdev.uscitizenship.ui

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dpappdev.uscitizenship.R
import com.dpappdev.uscitizenship.data.Question
import com.dpappdev.uscitizenship.data.StarredQuestions2008DataStore
import com.dpappdev.uscitizenship.data.StarredQuestionsDataStore
import com.dpappdev.uscitizenship.ui.theme.USCitizenshipTheme

@Composable
fun AllQuestionsScreen(
    questions: List<Question>,
    starredQuestions: List<String>,
    starredQuestionsDataStore: StarredQuestionsDataStore,
    textToSpeech: TextToSpeech,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        val borderPadding = 16.dp
        val textSize = 16.sp

        items(questions) { item ->
            val questionNumber = item.questionNumber
            val backgroundColor = if (questionNumber % 2 == 0) {
                MaterialTheme.colorScheme.surfaceVariant
            } else {
                MaterialTheme.colorScheme.background
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = backgroundColor)
                    .padding(borderPadding)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_volume_up_24),
                    contentDescription = "read out loud",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .clickable {
                            textToSpeech.speak(item.question, TextToSpeech.QUEUE_FLUSH, null, null)
                        },
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "$questionNumber. " + item.question,
                        fontSize = textSize,
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .clickable {
                                textToSpeech.speak(
                                    item.question,
                                    TextToSpeech.QUEUE_FLUSH,
                                    null,
                                    null
                                )
                            }
                    )
                    item.answer.forEach {
                        Row(
                            modifier = Modifier.clickable {
                                textToSpeech.speak(it, TextToSpeech.QUEUE_FLUSH, null, null)
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_volume_up_24),
                                contentDescription = "read out loud",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.padding(end = 8.dp)
                            )
                            Text(
                                text = it,
                                fontSize = textSize,
                            )
                        }
                    }
                }

                StarIcon(
                    starredQuestions = starredQuestions,
                    starredQuestionsDataStore = starredQuestionsDataStore,
                    questionNumber = questionNumber,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AllQuestionsPreview() {
    USCitizenshipTheme {
        AllQuestionsScreen(
            questions = listOf(
                Question(
                    questionNumber = 1,
                    question = "What is the supreme law of the land?",
                    answer = listOf("the Constitution"),
                ),
                Question(
                    questionNumber = 2,
                    question = "What does the Constitution do?",
                    answer = listOf(
                        "sets up the government",
                        "defines the government",
                        "protects basic rights of Americans"
                    ),
                ),
            ),
            starredQuestions = listOf("2,5,84"),
            starredQuestionsDataStore = StarredQuestions2008DataStore(LocalContext.current),
            textToSpeech = TextToSpeech(LocalContext.current) {},
        )
    }
}