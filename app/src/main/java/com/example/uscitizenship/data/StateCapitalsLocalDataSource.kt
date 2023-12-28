package com.example.uscitizenship.data

fun getStateCapital(state: String): String? {
    val capitalMap = mapOf(
        "Washington" to "Olympia",
        "Oregon" to "Salem"
    )
    return capitalMap[state]
}