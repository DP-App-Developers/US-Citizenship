@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.dpappdev.uscitizenship.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dpappdev.uscitizenship.MainScreen
import com.dpappdev.uscitizenship.R
import com.dpappdev.uscitizenship.billing.BillingManager
import com.dpappdev.uscitizenship.ui.theme.USCitizenshipTheme

@Composable
fun HomeScreen(
    currentTestYear: String,
    currentUserStateOrDistrict: String,
    currentUsRepresentative: String,
    allQuestionsCount: Int,
    starredQuestionsCount: Int,
    navController: NavController,
    modifier: Modifier = Modifier,
    isPremium: Boolean = false,
    billingManager: BillingManager? = null,
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
        var showNewUserBottomSheet by rememberSaveable { mutableStateOf(newUser) }
        var showPaywallBottomSheet by rememberSaveable { mutableStateOf(false) }
        val allQuestionsSubtitle = when (allQuestionsCount) {
            0 -> {
                "" // don't show subtitle because no questions are available yet
            }
            1 -> {
                "1 Question"
            }
            else -> {
                "$allQuestionsCount Questions"
            }
        }
        val starredQuestionsSubtitle = if (allQuestionsCount == 0) {
            "" // don't show subtitle because no questions are available yet
        } else if (starredQuestionsCount == 1) {
            "1 Question"
        } else {
            "$starredQuestionsCount Questions"
        }
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            BoxWithConstraints(
                modifier = modifier.weight(1f)
            ) {
                val columns = if (maxWidth < 600.dp) 1 else 2
                
                LazyVerticalGrid(
                    columns = GridCells.Fixed(columns),
                    contentPadding = PaddingValues(vertical = 32.dp, horizontal = 64.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                item {
                    HomeScreenCard(
                        title = "All Questions",
                        subtitle = allQuestionsSubtitle,
                        iconId = R.drawable.outline_book_ribbon_24,
                        onCardClick = {
                            if (newUser) {
                                showNewUserBottomSheet = true
                            } else {
                                navController.navigate(MainScreen.AllQuestions.name)
                            }
                        },
                    )
                }

                item {
                    HomeScreenCard(
                        title = "All Flash Cards",
                        subtitle = allQuestionsSubtitle,
                        iconId = R.drawable.outline_cards_stack_24,
                        onCardClick = {
                            if (newUser) {
                                showNewUserBottomSheet = true
                            } else {
                                navController.navigate(MainScreen.AllFlashCards.name)
                            }
                        },
                    )
                }

                item {
                    HomeScreenCard(
                        title = "Starred Questions",
                        subtitle = starredQuestionsSubtitle,
                        iconId = R.drawable.round_star_24,
                        onCardClick = {
                            if (newUser) {
                                showNewUserBottomSheet = true
                            } else if (!isPremium) {
                                showPaywallBottomSheet = true
                            } else {
                                navController.navigate(MainScreen.StarredQuestions.name)
                            }
                        },
                    )
                }

                item {
                    HomeScreenCard(
                        title = "Starred Flash Cards",
                        subtitle = starredQuestionsSubtitle,
                        iconId = R.drawable.outline_cards_star_24,
                        onCardClick = {
                            if (newUser) {
                                showNewUserBottomSheet = true
                            } else if (!isPremium) {
                                showPaywallBottomSheet = true
                            } else {
                                navController.navigate(MainScreen.StarredFlashCards.name)
                            }
                        },
                    )
                }
                }
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

        if (showNewUserBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showNewUserBottomSheet = false },
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
                            showNewUserBottomSheet = false
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

        if (showPaywallBottomSheet) {
            val context = LocalContext.current
            PaywallBottomSheet(
                onDismiss = { showPaywallBottomSheet = false },
                onUpgradeClick = {
                    billingManager?.launchPurchaseFlow(context as android.app.Activity)
                    showPaywallBottomSheet = false
                }
            )
        }
    }
}

@Composable
fun HomeScreenCard(
    title: String,
    subtitle: String,
    iconId: Int,
    onCardClick: () -> Unit,
) {
    OutlinedCard(
        onClick = onCardClick,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        modifier = Modifier.height(132.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .size(48.dp)
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = iconId),
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(29.dp),
                    contentDescription = null,
                )
            }

            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                maxLines = 2,
            )

            if (subtitle.isNotEmpty()) {
                Text(
                    text = subtitle,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                )
            }
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
            allQuestionsCount = 128,
            starredQuestionsCount = 15,
            navController = rememberNavController(),
            modifier = Modifier.fillMaxSize(),
        )
    }
}
