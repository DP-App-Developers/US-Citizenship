@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.uscitizenship.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.uscitizenship.data.UserStateDataStore
import com.example.uscitizenship.ui.theme.USCitizenshipTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun SettingsScreen(
    userStateDataStore: UserStateDataStore
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            // FIXME: change wording
            text = "Please provide your state and district information so we can generate accurate answers for your state's capital, Governor, Senators, and Representatives.",
            fontSize = 16.sp,
        )

        val defaultStateText = "Select your state"
        val states = getStates()
        var expandedForStates by rememberSaveable { mutableStateOf(false) }
        var selectedState by rememberSaveable { mutableStateOf(defaultStateText) }
        // We want to react on tap/press on TextField to show menu
        ExposedDropdownMenuBox(
            expanded = expandedForStates,
            onExpandedChange = { expandedForStates = it },
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
                            selectedState = state
                            expandedForStates = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    )
                }
            }
        }

        if (selectedState != defaultStateText) {
            val defaultRepresentativeText = "Select your U.S. Representative"
            val representatives = listOf("Adam", "David", "Susan")
            var expandedForRep by rememberSaveable { mutableStateOf(false) }
            var selectedRep by rememberSaveable { mutableStateOf(defaultRepresentativeText) }
            // We want to react on tap/press on TextField to show menu
            ExposedDropdownMenuBox(
                expanded = expandedForRep,
                onExpandedChange = { expandedForRep = it },
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

            if (selectedRep != defaultRepresentativeText) {
                Button(onClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        userStateDataStore.saveUserState(selectedState)
                    }
                }) {
                    Text("Save")
                }
            }
        }
    }
}

fun getStates() = listOf(
    "Alabama",
    "Alaska",
    "American Samoa",
    "Arizona",
    "Arkansas",
    "California",
    "Colorado",
    "Connecticut",
    "Delaware",
    "District of Columbia",
    "Florida",
    "Georgia",
    "Guam",
    "Hawaii",
    "Idaho",
    "Illinois",
    "Indiana",
    "Iowa",
    "Kansas",
    "Kentucky",
    "Louisiana",
    "Maine",
    "Maryland",
    "Massachusetts",
    "Michigan",
    "Minnesota",
    "Mississippi",
    "Missouri",
    "Montana",
    "Nebraska",
    "Nevada",
    "New Hampshire",
    "New Jersey",
    "New Mexico",
    "New York",
    "North Carolina",
    "North Dakota",
    "Northern Mariana Islands",
    "Ohio",
    "Oklahoma",
    "Oregon",
    "Pennsylvania",
    "Rhode Island",
    "South Carolina",
    "South Dakota",
    "Tennessee",
    "Texas",
    "Utah",
    "Vermont",
    "Virginia",
    "Virgin Islands",
    "Washington",
    "West Virginia",
    "Wisconsin",
    "Wyoming",
)

@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    USCitizenshipTheme {
        SettingsScreen(UserStateDataStore(LocalContext.current))
    }
}