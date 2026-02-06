package com.dpappdev.uscitizenship.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dpappdev.uscitizenship.R

@Composable
fun EmptyStarredState() {
    val borderPadding = 16.dp
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(borderPadding)) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Icon(
                painter = painterResource(id = R.drawable.shooting_star),
                contentDescription = "empty state icon",
                tint = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .size(width = 200.dp, height = 200.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Mark a question as starred and it will show up here.",
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }
    }
}
