@file:OptIn(ExperimentalMaterial3Api::class)

package com.dpappdev.uscitizenship.ui

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.LocalContentColor
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
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.UrlAnnotation
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dpappdev.uscitizenship.MainScreen
import com.dpappdev.uscitizenship.data.UsRepresentativeDataStore
import com.dpappdev.uscitizenship.data.UserStateDataStore
import com.dpappdev.uscitizenship.data.getStatesAndDistricts
import com.dpappdev.uscitizenship.data.getUsRepresentatives
import com.dpappdev.uscitizenship.ui.theme.USCitizenshipTheme
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalTextApi::class)
@Composable
fun SettingsScreen(
    userStateDataStore: UserStateDataStore,
    usRepresentativeDataStore: UsRepresentativeDataStore,
    currentUserStateOrDistrict: String,
    currentUsRepresentative: String,
    navController: NavController,
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(20.dp)
    ) {
        val defaultStateText = currentUserStateOrDistrict.ifEmpty {
            "Select your State"
        }
        val states = getStatesAndDistricts()
        var expandedForStates by rememberSaveable { mutableStateOf(false) }
        var selectedState by rememberSaveable { mutableStateOf(defaultStateText) }
        val selectRepText = "Select your U.S. Representative"
        val defaultRepresentativeText = currentUsRepresentative.ifEmpty {
            selectRepText
        }
        val defaultReps = if (currentUserStateOrDistrict.isEmpty()) {
            listOf()
        } else {
            getUsRepresentatives(currentUserStateOrDistrict)
        }
        var representatives by rememberSaveable { mutableStateOf(defaultReps) }
        var selectedRep by rememberSaveable { mutableStateOf(defaultRepresentativeText) }

        Text(
//            text = "Disclaimer: This application is not affiliated with any government entity.",
            text = "This is to provide you the names of your elected state officials.",
            fontSize = 12.sp,
            modifier = Modifier.padding(bottom = 12.dp),
        )

        // We want to react on tap/press on TextField to show menu
        ExposedDropdownMenuBox(
            expanded = expandedForStates,
            onExpandedChange = { expandedForStates = it },
            modifier = Modifier.padding(bottom = 12.dp),
        ) {
            TextField(
                // The `menuAnchor` modifier must be passed to the text field for correctness.
                modifier = Modifier.menuAnchor(),
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
                                selectedRep = selectRepText
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
            var expandedForRep by rememberSaveable { mutableStateOf(false) }
            // We want to react on tap/press on TextField to show menu
            ExposedDropdownMenuBox(
                expanded = expandedForRep,
                onExpandedChange = { expandedForRep = it },
                modifier = Modifier.padding(bottom = 12.dp),
            ) {
                TextField(
                    // The `menuAnchor` modifier must be passed to the text field for correctness.
                    modifier = Modifier.menuAnchor(),
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

            val annotatedString = buildAnnotatedString {
                val string = "Visit house.gov to find your U.S. Representative."
                val startIndex = string.indexOf("house.gov")
                val endIndex = startIndex + 9
                append(string)
                addStyle(
                    style = SpanStyle(textDecoration = TextDecoration.Underline),
                    start = startIndex,
                    end = endIndex,
                )
                addUrlAnnotation(
                    UrlAnnotation("https://www.house.gov/"),
                    start = startIndex,
                    end = endIndex,
                )
            }
            val uriHandler = LocalUriHandler.current
            ClickableText(
                text = annotatedString,
                style = TextStyle(
                    color = LocalContentColor.current,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    letterSpacing = 0.5.sp
                ),
                modifier = Modifier.padding(bottom = 24.dp),
                onClick = {
                    annotatedString
                        .getUrlAnnotations(it, it)
                        .firstOrNull()?.let { annotation ->
                            uriHandler.openUri(annotation.item.url)
                        }
                }
            )

            if (selectedRep != selectRepText) {
                BoxWithConstraints(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        modifier = Modifier
                            .width(maxWidth * 3 / 4)
                            .padding(bottom = 8.dp),
                        onClick = {
                            runBlocking {
                                // making saving synchronous to prevent showing the new user bottom sheet when going back to home
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

@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    USCitizenshipTheme {
        SettingsScreen(
            userStateDataStore = UserStateDataStore(LocalContext.current),
            usRepresentativeDataStore = UsRepresentativeDataStore(LocalContext.current),
            currentUserStateOrDistrict = "",
            currentUsRepresentative = "",
            rememberNavController(),
        )
    }
}