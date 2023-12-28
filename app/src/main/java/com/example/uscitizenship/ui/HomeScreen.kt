package com.example.uscitizenship.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uscitizenship.ui.theme.USCitizenshipTheme

@Composable
fun HomeScreen(
    onFlashCardsButtonClicked:() -> Unit,
    onAllQuestionsButtonClicked: () -> Unit,
    onSettingsButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = onFlashCardsButtonClicked
        ) {
            Text("FLASH CARDS")
        }
        Button(
            onClick = onAllQuestionsButtonClicked
        ) {
            Text("ALL QUESTIONS")
        }
        Button(
            onClick = onSettingsButtonClicked
        ) {
            Text("SETTINGS")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    USCitizenshipTheme {
        HomeScreen(
            onFlashCardsButtonClicked = {},
            onAllQuestionsButtonClicked = {},
            onSettingsButtonClicked = {},
            modifier = Modifier.fillMaxSize(),
        )
    }
}