@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.uscitizenship.ui

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uscitizenship.MainScreen
import com.example.uscitizenship.ui.theme.USCitizenshipTheme

@Composable
fun HomeScreen(
    currentUserStateOrDistrict: String,
    currentUsRepresentative: String,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val loading = currentUserStateOrDistrict == "loading" || currentUsRepresentative == "loading"
    if (loading) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                color = MaterialTheme.colorScheme.secondary,
            )
        }
    } else {
        val newUser = currentUserStateOrDistrict.isEmpty() || currentUsRepresentative.isEmpty()
        var showBottomSheet by rememberSaveable { mutableStateOf(false) }
        Column(
            modifier = modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = {
                    if (newUser) {
                        showBottomSheet = true
                    } else {
                        navController.navigate(MainScreen.FlashCards.name)
                    }
                }
            ) {
                Text("FLASH CARDS")
            }
            Button(
                onClick = {
                    if (newUser) {
                        showBottomSheet = true
                    } else {
                        navController.navigate(MainScreen.AllQuestions.name)
                    }
                }
            ) {
                Text("ALL QUESTIONS")
            }
            Button(
                onClick = {
                    navController.navigate(MainScreen.Settings.name)
                }
            ) {
                Text("SETTINGS")
            }
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
                        text = "Start by choosing your State and U.S. Representative. This is a one-time task to update the questions about your State.",
                        modifier = Modifier.padding(bottom = 8.dp),
                    )
                    Button(onClick = {
                        showBottomSheet = false
                        navController.navigate(MainScreen.Settings.name)
                    }) {
                        Text("START")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    USCitizenshipTheme {
        HomeScreen(
            currentUserStateOrDistrict = "Alaska",
            currentUsRepresentative = "Susan",
            navController = rememberNavController(),
            modifier = Modifier.fillMaxSize(),
        )
    }
}