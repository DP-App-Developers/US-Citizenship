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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.uscitizenship.data.Question
import com.example.uscitizenship.data.UsRepresentativeDataStore
import com.example.uscitizenship.data.UserStateDataStore
import com.example.uscitizenship.data.getStateCapital
import com.example.uscitizenship.ui.AllQuestionsScreen
import com.example.uscitizenship.ui.AllQuestionsViewModel
import com.example.uscitizenship.ui.FlashCardsScreen
import com.example.uscitizenship.ui.HomeScreen
import com.example.uscitizenship.ui.LoadingScreen
import com.example.uscitizenship.ui.SettingsScreen

enum class MainScreen(@StringRes val title: Int) {
    Loading(title = R.string.title_loading),
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
        val loadingInitial = "loading"
        val userStateDataStore = UserStateDataStore(LocalContext.current)
        val usRepresentativeDataStore = UsRepresentativeDataStore(LocalContext.current)
        val userStateOrDistrict = userStateDataStore.getUserState.collectAsState(initial = loadingInitial).value
        val usRepresentative = usRepresentativeDataStore.getUsRepresentative.collectAsState(initial = loadingInitial).value
        val uiState by allQuestionsViewModel.uiState.collectAsState()
        val questionsWithAnswers = consolidateAnswers(userStateOrDistrict, usRepresentative, uiState.questions)

        val initialScreen = if (usRepresentative == loadingInitial) {
            MainScreen.Loading.name
        } else if (userStateOrDistrict.isEmpty()) {
            MainScreen.Settings.name
        } else {
            MainScreen.Home.name
        }

        NavHost(
            navController = navController,
            startDestination = initialScreen,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MainScreen.Loading.name) {
                LoadingScreen()
            }
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
                SettingsScreen(userStateDataStore, usRepresentativeDataStore)
            }
            composable(route = MainScreen.FlashCards.name) {
                FlashCardsScreen(
                    questions = questionsWithAnswers,
                )
            }
            composable(route = MainScreen.AllQuestions.name) {
                AllQuestionsScreen(
                    questions = questionsWithAnswers,
                )
            }
        }
    }
}

// FIXME: Use hilt to inject dataStore to repository
fun consolidateAnswers(
    userStateOrDistrict: String,
    usRepresentative: String,
    questions: List<Question>,
): List<Question> {
    val stateCapital = getStateCapital(userStateOrDistrict)
    if (usRepresentative.isNotEmpty()) {
        questions[22].answer = listOf(usRepresentative)
    }
    if (!stateCapital.isNullOrEmpty()) {
        questions[43].answer = listOf(stateCapital)
    }
    return questions
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