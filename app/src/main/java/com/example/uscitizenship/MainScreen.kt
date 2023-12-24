package com.example.uscitizenship

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.uscitizenship.ui.AllQuestionsScreen
import com.example.uscitizenship.ui.AllQuestionsViewModel
import com.example.uscitizenship.ui.FlashCardsScreen
import com.example.uscitizenship.ui.HomeScreen
import com.example.uscitizenship.ui.SettingsScreen

enum class MainScreen(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    Settings(title = R.string.title_settings),
    FlashCards(title = R.string.title_flash_cards),
    AllQuestions(title = R.string.title_all_questions),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun USCitizenApp(
    allQuestionsViewModel: AllQuestionsViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = MainScreen.valueOf(
        backStackEntry?.destination?.route ?: MainScreen.Home.name
    )

    Scaffold(
        topBar = {
            USCitizenAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val uiState by allQuestionsViewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = MainScreen.Settings.name,
//            startDestination = MainScreen.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MainScreen.Home.name) {
                HomeScreen(
                    onFlashCardsButtonClicked = {
                        navController.navigate(MainScreen.FlashCards.name)
                    },
                    onAllQuestionsButtonClicked = {
                        navController.navigate(MainScreen.AllQuestions.name)
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
            composable(route = MainScreen.Settings.name) {
                SettingsScreen()
            }
            composable(route = MainScreen.FlashCards.name) {
                FlashCardsScreen(
                    questions = uiState.questions,
                )
            }
            composable(route = MainScreen.AllQuestions.name) {
                AllQuestionsScreen(
                    questions = uiState.questions,
                )
            }
        }
    }
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun USCitizenAppBar(
    currentScreen: MainScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}