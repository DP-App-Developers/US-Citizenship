package com.dpappdev.uscitizenship.ui

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dpappdev.uscitizenship.R
import com.dpappdev.uscitizenship.data.Question
import com.dpappdev.uscitizenship.data.StarredQuestionsDataStore
import com.dpappdev.uscitizenship.ui.theme.USCitizenshipTheme

@Composable
fun StarredQuestionsScreen(
    questions: List<Question>,
    starredQuestions: List<String>,
    starredQuestionsDataStore: StarredQuestionsDataStore,
    textToSpeech: TextToSpeech,
) {
    val borderPadding = 16.dp
    if (starredQuestions.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(borderPadding)
        ) {
            Text(
                text = "Mark a question as starred and it will show up here.",
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center),
                fontSize = 20.sp
            )
        }
        return
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        val textSize = 16.sp

        val starredQuestionsList = questions.filter { starredQuestions.contains(it.questionNumber.toString()) }

        itemsIndexed(starredQuestionsList) { index, item ->
            val questionNumber = item.questionNumber
            val backgroundColor = if (index % 2 == 0) {
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
fun StarredQuestionsPreview() {
    USCitizenshipTheme {
        StarredQuestionsScreen(
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
            starredQuestionsDataStore = StarredQuestionsDataStore(LocalContext.current),
            textToSpeech = TextToSpeech(LocalContext.current) {},
        )
    }
}