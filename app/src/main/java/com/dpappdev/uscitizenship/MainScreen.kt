package com.dpappdev.uscitizenship

import android.speech.tts.TextToSpeech
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dpappdev.uscitizenship.data.StarredQuestions2025DataStore
import com.dpappdev.uscitizenship.data.StarredQuestions2008DataStore
import com.dpappdev.uscitizenship.data.TestYearDataStore
import com.dpappdev.uscitizenship.data.UsRepresentativeDataStore
import com.dpappdev.uscitizenship.data.UserStateDataStore
import com.dpappdev.uscitizenship.ui.AllQuestionsScreen
import com.dpappdev.uscitizenship.ui.AllQuestionsViewModel
import com.dpappdev.uscitizenship.ui.AllQuestionsViewModelFactory
import com.dpappdev.uscitizenship.ui.FlashCardsScreen
import com.dpappdev.uscitizenship.ui.HomeScreen
import com.dpappdev.uscitizenship.ui.SettingsScreen
import com.dpappdev.uscitizenship.ui.StarredQuestionsScreen

enum class MainScreen(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    Settings(title = R.string.title_settings),
    FlashCards(title = R.string.title_flash_cards),
    AllQuestions(title = R.string.title_all_questions),
    StarredQuestions(title = R.string.title_starred_questions),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun USCitizenApp(
    textToSpeech: TextToSpeech,
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route ?: MainScreen.Home.name
    // Get the name of the current screen
    val currentScreen = MainScreen.valueOf(currentRoute)

    Scaffold(
        topBar = {
            USCitizenAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                navigateToSettings = { navController.navigate(MainScreen.Settings.name) },
            )
        },
        modifier = Modifier.fillMaxSize().statusBarsPadding().navigationBarsPadding().displayCutoutPadding()
    ) { innerPadding ->
        val loadingInitial = "loading"
        val context = LocalContext.current
        val testYearDataStore = remember { TestYearDataStore(context) }
        val userStateDataStore = remember { UserStateDataStore(context) }
        val usRepresentativeDataStore = remember { UsRepresentativeDataStore(context) }
        val testYear = testYearDataStore.getTestYearFlow.collectAsState(initial = loadingInitial).value
        val userStateOrDistrict = userStateDataStore.getUserState.collectAsState(initial = loadingInitial).value
        val usRepresentative = usRepresentativeDataStore.getUsRepresentative.collectAsState(initial = loadingInitial).value

        val starredQuestionsDataStore = remember(testYear) {
            when (testYear) {
                "2008 Civics Test" -> StarredQuestions2008DataStore(context)
                "2025 Civics Test" -> StarredQuestions2025DataStore(context)
                else -> null // loading state - don't create datastore yet
            }
        }
        val starredQuestionsString = starredQuestionsDataStore?.getStarredQuestions?.collectAsState(initial = "")?.value ?: ""
        // "".split(",") returns {""}, which is not desired
        // the desired behavior is to return empty list
        val starredQuestions = starredQuestionsString.split(",").takeIf {it.size > 1 || it[0].isNotEmpty()} ?: emptyList()

        val allQuestionsViewModel: AllQuestionsViewModel = viewModel(
            factory = AllQuestionsViewModelFactory(testYear, userStateOrDistrict, usRepresentative)
        )
        LaunchedEffect(currentRoute, testYear, userStateOrDistrict, usRepresentative) {
            if (currentRoute == MainScreen.Home.name) { // reload data when user returns to Home screen
                allQuestionsViewModel.reload(testYear, userStateOrDistrict, usRepresentative)
            }
        }
        val uiState by allQuestionsViewModel.uiState.collectAsState()
        val questionsWithAnswers = uiState.questions

        NavHost(
            navController = navController,
            startDestination = MainScreen.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MainScreen.Home.name) {
                HomeScreen(
                    currentTestYear = testYear,
                    currentUserStateOrDistrict = userStateOrDistrict,
                    currentUsRepresentative = usRepresentative,
                    navController = navController,
                    modifier = Modifier.fillMaxSize(),
                )
            }
            composable(route = MainScreen.FlashCards.name) {
                FlashCardsScreen(
                    questionsInOrder = questionsWithAnswers,
                    starredQuestions = starredQuestions,
                    starredQuestionsDataStore = starredQuestionsDataStore,
                    textToSpeech = textToSpeech,
                )
            }
            composable(route = MainScreen.AllQuestions.name) {
                AllQuestionsScreen(
                    questions = questionsWithAnswers,
                    starredQuestions = starredQuestions,
                    starredQuestionsDataStore = starredQuestionsDataStore,
                    textToSpeech = textToSpeech,
                )
            }
            composable(route = MainScreen.StarredQuestions.name) {
                StarredQuestionsScreen(
                    questions = questionsWithAnswers,
                    starredQuestions = starredQuestions,
                    starredQuestionsDataStore = starredQuestionsDataStore,
                    textToSpeech = textToSpeech,
                )
            }
            composable(route = MainScreen.Settings.name) {
                SettingsScreen(
                    testYearDataStore = testYearDataStore,
                    userStateDataStore = userStateDataStore,
                    usRepresentativeDataStore = usRepresentativeDataStore,
                    currentTestYear = testYear,
                    currentUserStateOrDistrict = userStateOrDistrict,
                    currentUsRepresentative = usRepresentative,
                    navController = navController,
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
    navigateToSettings: () -> Unit,
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
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button),
                    )
                }
            }
        },
        actions = {
            if (!canNavigateBack) { // show the settings icon in home page
                IconButton(onClick = navigateToSettings) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                }
            }
        },
    )
}
