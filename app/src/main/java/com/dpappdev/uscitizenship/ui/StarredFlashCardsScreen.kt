package com.dpappdev.uscitizenship.ui

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dpappdev.uscitizenship.R
import com.dpappdev.uscitizenship.data.FlashCardsShuffleDataStore
import com.dpappdev.uscitizenship.data.Question
import com.dpappdev.uscitizenship.data.StarredQuestions2008DataStore
import com.dpappdev.uscitizenship.data.StarredQuestionsDataStore
import com.dpappdev.uscitizenship.ui.theme.USCitizenshipTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun StarredFlashCardsScreen(
    starredQuestionsList: List<Question>,
    starredQuestions: List<String>,
    starredQuestionsDataStore: StarredQuestionsDataStore?,
    totalNumberOfQuestions: Int,
    textToSpeech: TextToSpeech,
) {
    // Create a snapshot of the initial starred questions list so un-starring doesn't remove cards until user backs out
    val initialStarredQuestionsList by rememberSaveable {
        mutableStateOf(starredQuestionsList)
    }
    
    if (initialStarredQuestionsList.isEmpty()) {
        EmptyStarredState()
        return
    }

    var index by rememberSaveable { mutableIntStateOf(0) }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val questionsShuffled by rememberSaveable {
        mutableStateOf(initialStarredQuestionsList.shuffled())
    }
    val shuffleDataStore = FlashCardsShuffleDataStore(LocalContext.current)
    val isShuffleOn = shuffleDataStore.isShuffleOn.collectAsState(initial = false).value
    val questions: List<Question>
    val shuffleIconColor: Color
    if (isShuffleOn) {
        questions = questionsShuffled
        shuffleIconColor = MaterialTheme.colorScheme.primary
    } else {
        questions = initialStarredQuestionsList
        shuffleIconColor = MaterialTheme.colorScheme.outline
    }
    
    val questionNumber = questions[index].questionNumber

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(vertical = 8.dp)
                .padding(horizontal = 16.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text(
                    text = "Question $questionNumber / $totalNumberOfQuestions",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                )

                StarIcon(
                    starredQuestions = starredQuestions,
                    starredQuestionsDataStore = starredQuestionsDataStore,
                    questionNumber = questionNumber,
                )
            }

            ElevatedCard(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(bottom = 100.dp)
                    .clickable(enabled = !expanded) { expanded = true },
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .clickable {
                                textToSpeech.speak(questions[index].question, TextToSpeech.QUEUE_FLUSH, null, null)
                            },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_volume_up_24),
                            contentDescription = "read out loud",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .padding(top = 2.dp)
                        )
                        Text(
                            text = questions[index].question,
                            fontSize = 20.sp,
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    if (!expanded) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_keyboard_arrow_down_24),
                            contentDescription = "reveal answer",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    } else {
                        Divider(color = MaterialTheme.colorScheme.outline)
                        Spacer(modifier = Modifier.height(20.dp))
                        questions[index].answer.forEach {
                            Row(
                                modifier = Modifier
                                    .padding(start = 32.dp)
                                    .clickable {
                                        textToSpeech.speak(it, TextToSpeech.QUEUE_FLUSH, null, null)
                                    },
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_volume_up_24),
                                    contentDescription = "read out loud",
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier
                                        .padding(end = 8.dp)
                                        .padding(top = 2.dp)
                                )
                                Text(
                                    text = it,
                                    fontSize = 20.sp,
                                )
                            }
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
                if (index == 0) {
                    index = questions.lastIndex
                } else {
                    index--
                }
            },
        ) {
            Text(text = "Previous")
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_shuffle),
            contentDescription = "shuffle",
            tint = shuffleIconColor,
            modifier = Modifier
                .size(width = 82.dp, height = 82.dp)
                .padding(16.dp)
                .align(Alignment.BottomCenter)
                .clickable {
                    CoroutineScope(Dispatchers.Main).launch {
                        shuffleDataStore.saveShuffleOn(!isShuffleOn)
                        // update index so the question remains the same on the screen
                        if (isShuffleOn) {
                            // turning shuffle off
                            initialStarredQuestionsList.forEachIndexed { i, question ->
                                if (question.questionNumber == questionNumber) {
                                    index = i
                                    return@forEachIndexed
                                }
                            }
                        } else {
                            // turning shuffle on
                            questionsShuffled.forEachIndexed { i, question ->
                                if (question.questionNumber == questionNumber) {
                                    index = i
                                    return@forEachIndexed
                                }
                            }
                        }
                    }
                }
        )

        Button(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            onClick = {
                expanded = false
                if (index == questions.lastIndex) {
                    index = 0
                } else {
                    index++
                }
            },
        ) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StarredFlashCardsPreview() {
    USCitizenshipTheme {
        StarredFlashCardsScreen(
            starredQuestionsList = listOf(
                Question(
                    questionNumber = 2,
                    question = "What does the Constitution do?",
                    answer = listOf(
                        "sets up the government",
                        "defines the government",
                        "protects basic rights of Americans"
                    ),
                ),
                Question(
                    questionNumber = 5,
                    question = "What do we call the first ten amendments to the Constitution?",
                    answer = listOf("the Bill of Rights"),
                ),
            ),
            starredQuestions = listOf("2", "5"),
            starredQuestionsDataStore = StarredQuestions2008DataStore(LocalContext.current),
            totalNumberOfQuestions = 100,
            textToSpeech = TextToSpeech(LocalContext.current) {},
        )
    }
}
