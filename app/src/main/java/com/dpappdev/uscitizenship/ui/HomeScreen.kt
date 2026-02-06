@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.dpappdev.uscitizenship.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dpappdev.uscitizenship.MainScreen
import com.dpappdev.uscitizenship.ui.theme.USCitizenshipTheme

@Composable
fun HomeScreen(
    currentTestYear: String,
    currentUserStateOrDistrict: String,
    currentUsRepresentative: String,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val loading = currentTestYear == "loading" || currentUserStateOrDistrict == "loading" || currentUsRepresentative == "loading"
    if (loading) {
        Box(modifier = Modifier.fillMaxSize()) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                color = MaterialTheme.colorScheme.secondary,
            )
        }
    } else {
        val newUser = currentTestYear.isEmpty() || currentUserStateOrDistrict.isEmpty() || currentUsRepresentative.isEmpty()
        var showBottomSheet by rememberSaveable { mutableStateOf(newUser) }
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                HomeScreenCard(
                    cardText = "Flash Cards",
                    onCardClick = {
                        if (newUser) {
                            showBottomSheet = true
                        } else {
                            navController.navigate(MainScreen.FlashCards.name)
                        }
                    },
                )

                HomeScreenCard(
                    cardText = "All Questions",
                    onCardClick = {
                        if (newUser) {
                            showBottomSheet = true
                        } else {
                            navController.navigate(MainScreen.AllQuestions.name)
                        }
                    },
                )

                HomeScreenCard(
                    cardText = "Starred Questions",
                    onCardClick = {
                        if (newUser) {
                            showBottomSheet = true
                        } else {
                            navController.navigate(MainScreen.StarredQuestions.name)
                        }
                    },
                )

                HomeScreenCard(
                    cardText = "Starred Flash Cards",
                    onCardClick = {
                        if (newUser) {
                            showBottomSheet = true
                        } else {
                            navController.navigate(MainScreen.StarredFlashCards.name)
                        }
                    },
                )
            }

            Text(
                text = "Disclaimer: This application is not affiliated with any government entity.",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray),
            )
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
            ) {
                Column(modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 50.dp)
                ) {
                    Text(
                        text = "Welcome!",
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "Start by choosing your civics test, State and U.S. Representative.",
                        modifier = Modifier.padding(bottom = 8.dp),
                    )
                    Box(modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        Button(onClick = {
                            showBottomSheet = false
                            navController.navigate(MainScreen.Settings.name)
                        }) {
                            Text(
                                text = "Start",
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreenCard(
    cardText: String,
    onCardClick: () -> Unit,
) {
    OutlinedCard(
        onClick = onCardClick,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
        modifier = Modifier
            .padding(bottom = 16.dp)
            .size(width = 240.dp, height = 70.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = cardText,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    USCitizenshipTheme {
        HomeScreen(
            currentTestYear = "",
            currentUserStateOrDistrict = "Alaska",
            currentUsRepresentative = "Susan",
            navController = rememberNavController(),
            modifier = Modifier.fillMaxSize(),
        )
    }
}
