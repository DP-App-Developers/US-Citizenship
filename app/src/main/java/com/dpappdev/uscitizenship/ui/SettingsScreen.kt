@file:OptIn(ExperimentalMaterial3Api::class)

package com.dpappdev.uscitizenship.ui

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dpappdev.uscitizenship.MainScreen
import com.dpappdev.uscitizenship.data.TestYearDataStore
import com.dpappdev.uscitizenship.data.UsRepresentativeDataStore
import com.dpappdev.uscitizenship.data.UserStateDataStore
import com.dpappdev.uscitizenship.data.getStatesAndDistricts
import com.dpappdev.uscitizenship.data.getUsRepresentatives
import com.dpappdev.uscitizenship.ui.theme.USCitizenshipTheme
import kotlinx.coroutines.runBlocking

@Composable
fun SettingsScreen(
    testYearDataStore: TestYearDataStore,
    userStateDataStore: UserStateDataStore,
    usRepresentativeDataStore: UsRepresentativeDataStore,
    currentTestYear: String,
    currentUserStateOrDistrict: String,
    currentUsRepresentative: String,
    navController: NavController,
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(20.dp)
    ) {
        val defaultTestYearText = currentTestYear.ifEmpty {
            "Select your test"
        }
        var expandedForTestYears by rememberSaveable { mutableStateOf(false) }
        var selectedTestYear by rememberSaveable { mutableStateOf(defaultTestYearText) }
        val testYears = listOf("2008 Civics Test", "2025 Civics Test")

        val defaultStateText = currentUserStateOrDistrict.ifEmpty {
            "Select your State"
        }
        val states = getStatesAndDistricts()
        var expandedForStates by rememberSaveable { mutableStateOf(false) }
        var selectedState by rememberSaveable { mutableStateOf(defaultStateText) }
        val defaultRepText = "Select your U.S. Representative"
        val defaultRepresentativeText = currentUsRepresentative.ifEmpty {
            defaultRepText
        }
        val defaultReps = if (currentUserStateOrDistrict.isEmpty()) {
            listOf()
        } else {
            getUsRepresentatives(currentUserStateOrDistrict)
        }
        var representatives by rememberSaveable { mutableStateOf(defaultReps) }
        var selectedRep by rememberSaveable { mutableStateOf(defaultRepresentativeText) }

        Text(
            text = "Choose 2008 Civics Test if you file Form N-400 before October 20, 2025. Choose 2025 Civics Test if you file Form N-400 on or after October 20, 2025.",
            fontSize = 14.sp,
        )

        // We want to react on tap/press on TextField to show menu
        ExposedDropdownMenuBox(
            expanded = expandedForTestYears,
            onExpandedChange = { expandedForTestYears = it },
            modifier = Modifier.padding(bottom = 36.dp),
        ) {
            TextField(
                // The `menuAnchor` modifier must be passed to the text field for correctness.
                modifier = Modifier.menuAnchor(MenuAnchorType.PrimaryNotEditable, true),
                readOnly = true,
                value = selectedTestYear,
                onValueChange = {},
                label = { Text("Civics test") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedForTestYears) },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
            )
            ExposedDropdownMenu(
                expanded = expandedForTestYears,
                onDismissRequest = { expandedForTestYears = false },
            ) {
                testYears.forEach { test ->
                    DropdownMenuItem(
                        text = { Text(test) },
                        onClick = {
                            selectedTestYear = test
                            expandedForTestYears = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    )
                }
            }
        }

        if (selectedTestYear == "2008 Civics Test" || selectedTestYear == "2025 Civics Test") {

            Text(
                text = "This is to provide you the names of your elected state officials.",
                fontSize = 14.sp,
            )

            // We want to react on tap/press on TextField to show menu
            ExposedDropdownMenuBox(
                expanded = expandedForStates,
                onExpandedChange = { expandedForStates = it },
                modifier = Modifier.padding(bottom = 36.dp),
            ) {
                TextField(
                    // The `menuAnchor` modifier must be passed to the text field for correctness.
                    modifier = Modifier.menuAnchor(MenuAnchorType.PrimaryNotEditable, true),
                    readOnly = true,
                    value = selectedState,
                    onValueChange = {},
                    label = { Text("State or District") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedForStates) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                )
                ExposedDropdownMenu(
                    expanded = expandedForStates,
                    onDismissRequest = { expandedForStates = false },
                ) {
                    states.forEach { state ->
                        DropdownMenuItem(
                            text = { Text(state) },
                            onClick = {
                                if (selectedState != state) {
                                    selectedState = state
                                    selectedRep = defaultRepText
                                    representatives = getUsRepresentatives(selectedState)
                                }
                                expandedForStates = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                        )
                    }
                }
            }

            if (representatives.isNotEmpty()) {
                HouseGovWebsite()

                var expandedForRep by rememberSaveable { mutableStateOf(false) }
                // We want to react on tap/press on TextField to show menu
                ExposedDropdownMenuBox(
                    expanded = expandedForRep,
                    onExpandedChange = { expandedForRep = it },
                    modifier = Modifier.padding(bottom = 12.dp),
                ) {
                    TextField(
                        // The `menuAnchor` modifier must be passed to the text field for correctness.
                        modifier = Modifier.menuAnchor(MenuAnchorType.PrimaryNotEditable, true),
                        readOnly = true,
                        value = selectedRep,
                        onValueChange = {},
                        label = { Text("U.S. Representative") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedForRep) },
                        colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    )
                    ExposedDropdownMenu(
                        expanded = expandedForRep,
                        onDismissRequest = { expandedForRep = false },
                    ) {
                        representatives.forEach { representative ->
                            DropdownMenuItem(
                                text = { Text(representative) },
                                onClick = {
                                    selectedRep = representative
                                    expandedForRep = false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                            )
                        }
                    }
                }

                val showSaveButton = selectedTestYear != "Select your test" && selectedState != "Select your State" && selectedRep != "Select your U.S. Representative"
                if (showSaveButton) {
                    BoxWithConstraints(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            modifier = Modifier
                                .width(maxWidth * 3 / 4)
                                .padding(vertical = 24.dp),
                            onClick = {
                                runBlocking {
                                    // making saving synchronous to prevent showing the new user bottom sheet when going back to home
                                    testYearDataStore.saveTestYear(selectedTestYear)
                                    userStateDataStore.saveUserState(selectedState)
                                    usRepresentativeDataStore.saveUsRepresentative(selectedRep)

                                    navController.navigate(MainScreen.Home.name) {
                                        popUpTo(MainScreen.Home.name) {
                                            inclusive = true
                                        }
                                    }
                                }
                            }
                        ) {
                            Text("Save")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HouseGovWebsite() {
    val annotatedString = buildAnnotatedString {
        append("Visit ")
        withLink(
            LinkAnnotation.Url(
                url = "https://www.house.gov/",
                styles = TextLinkStyles(
                    style = SpanStyle(
                        textDecoration = TextDecoration.Underline
                    )
                )
            )
        ) {
            append("house.gov")
        }
        append(" to find your U.S. Representative based on your zip code.")
    }
    Text(
        text = annotatedString,
        color = LocalContentColor.current,
        fontSize = 14.sp,
    )
}

@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    USCitizenshipTheme {
        SettingsScreen(
            testYearDataStore = TestYearDataStore(LocalContext.current),
            userStateDataStore = UserStateDataStore(LocalContext.current),
            usRepresentativeDataStore = UsRepresentativeDataStore(LocalContext.current),
            currentTestYear = "",
            currentUserStateOrDistrict = "",
            currentUsRepresentative = "",
            rememberNavController(),
        )
    }
}
