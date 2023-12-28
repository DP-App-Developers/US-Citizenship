package com.example.uscitizenship.data

fun getGovernor(state: String): String? {
    val governorMap = mapOf(
        "Oregon" to "Tina"
    )
    return governorMap[state]
}