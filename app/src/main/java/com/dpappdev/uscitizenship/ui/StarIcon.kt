package com.dpappdev.uscitizenship.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dpappdev.uscitizenship.R
import com.dpappdev.uscitizenship.data.StarredQuestionsDataStore
import com.dpappdev.uscitizenship.data.StarredQuestionsDataStoreInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun StarIcon(
    starredQuestions: List<String>,
    starredQuestionsDataStore: StarredQuestionsDataStoreInterface,
    questionNumber: Int,
) {
    val starIcon: Int
    val starIconContentDescription: String
    if (starredQuestions.contains(questionNumber.toString())) {
        starIcon = R.drawable.round_star_24
        starIconContentDescription = "unmark question $questionNumber as starred"
    } else {
        starIcon = R.drawable.round_star_outline_24
        starIconContentDescription = "mark question $questionNumber as starred"
    }

    Icon(
        painter = painterResource(id = starIcon),
        contentDescription = starIconContentDescription,
        tint = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(start = 8.dp)
            .size(width = 40.dp, height = 40.dp)
            .clickable {
                CoroutineScope(Dispatchers.Main).launch {
                    starredQuestions.toMutableList().run {
                        if (starredQuestions.contains("$questionNumber")) {
                            remove("$questionNumber")
                        } else {
                            add("$questionNumber")
                        }
                        starredQuestionsDataStore.saveStarredQuestions(joinToString(separator = ","))
                    }
                }
            },
    )
}

@Preview(showBackground = true)
@Composable
fun StarIconPreview() {
    StarIcon(
        starredQuestions = listOf("1", "2", "78"),
        starredQuestionsDataStore = StarredQuestionsDataStore(LocalContext.current),
        questionNumber = 2
    )
}