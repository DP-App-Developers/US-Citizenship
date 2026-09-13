package com.dpappdev.uscitizenship.ui

import android.content.Context
import android.media.MediaPlayer

fun playAudio(context: Context, resourceName: String) {
    val resId = context.resources.getIdentifier(resourceName, "raw", context.packageName)
    if (resId != 0) {
        MediaPlayer.create(context, resId)?.apply {
            setOnCompletionListener { release() }
            start()
        }
    }
}

fun questionAudioName(testYear: String, questionNumber: Int): String {
    val year = if (testYear.startsWith("2008")) "2008" else "2025"
    return "t${year}_q${questionNumber.toString().padStart(3, '0')}_q"
}

fun answerAudioName(answerText: String): String {
    val normalized = answerText.lowercase()
        .replace(Regex("[^a-z0-9]+"), "_")
        .trimStart('_')
        .trimEnd('_')
        .take(100)
    return "qa_$normalized"
}
