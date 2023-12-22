package com.example.uscitizenship.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uscitizenship.data.Question
import com.example.uscitizenship.ui.theme.USCitizenshipTheme

@Composable
fun AllQuestionsScreen(
    questions: List<Question>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        var questionCount = 1
        questions.forEach {
            val questionTitle = it.question
            Text(
                text = "$questionCount. $questionTitle",
                modifier = Modifier.padding(
                    top = 8.dp,
                    start = 8.dp,
                    end = 8.dp,
                )
            )
            questionCount++
            val bullet = "\u2022"
            val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 12.sp))
            Text(
                text = buildAnnotatedString {
                    it.answer.forEach { bulletItem ->
                        withStyle(style = paragraphStyle) {
                            append("\t\t\t")
                            append(bullet)
                            append("\t\t")
                            append(bulletItem)
                        }
                    }
                },
                modifier = Modifier.padding(8.dp)
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