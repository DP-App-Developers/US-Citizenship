package com.dpappdev.uscitizenship.data

data class Question(
    val questionNumber: Int,
    val question: String,
    var answer: List<String>,
)