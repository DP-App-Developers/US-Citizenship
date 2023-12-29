@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.uscitizenship.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uscitizenship.MainScreen
import com.example.uscitizenship.data.UsRepresentativeDataStore
import com.example.uscitizenship.data.UserStateDataStore
import com.example.uscitizenship.data.getStatesAndDistricts
import com.example.uscitizenship.data.getUsRepresentatives
import com.example.uscitizenship.ui.theme.USCitizenshipTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
        .padding(horizontal = 16.dp)
        .padding(top = 16.dp)
    ) {
        val defaultStateText = currentUserStateOrDistrict.ifEmpty {
            "Select your state"
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

        if (currentUserStateOrDistrict.isEmpty() || currentUsRepresentative.isEmpty()) {
            Text(
                text = "Welcome!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp),
            )
        }

        Text(
            // FIXME: change wording
            text = "Please provide your state and district information so we can generate accurate answers for your state's capital, Governor, Senators, and Representatives.",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 8.dp),
        )

        // We want to react on tap/press on TextField to show menu
        ExposedDropdownMenuBox(
            expanded = expandedForStates,
            onExpandedChange = { expandedForStates = it },
            modifier = Modifier.padding(bottom = 8.dp),
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
                modifier = Modifier.padding(bottom = 8.dp),
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

            if (selectedRep != selectRepText) {
                Button(
                    modifier = Modifier.padding(bottom = 8.dp),
                    onClick = {
                        CoroutineScope(Dispatchers.IO).launch {
                            userStateDataStore.saveUserState(selectedState)
                            usRepresentativeDataStore.saveUsRepresentative(selectedRep)
                        }
                        navController.navigate(MainScreen.Home.name) {
                            popUpTo(MainScreen.Home.name) {
                                inclusive = true
                            }
                        }
                    }
                ) {
                    Text("SAVE")
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