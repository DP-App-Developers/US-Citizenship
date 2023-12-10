package com.example.uscitizenship.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.uscitizenship.ui.theme.USCitizenshipTheme

@Composable
fun HomeScreen(
    onAllQuestionsButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = { /*TODO*/ }
        ) {
            Text("Flash cards")
        }
        Button(
            onClick = onAllQuestionsButtonClicked
        ) {
            Text("All Questions")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    USCitizenshipTheme {
        HomeScreen(
            onAllQuestionsButtonClicked = {},
            modifier = Modifier.fillMaxSize(),
        )
    }
}