@file:OptIn(ExperimentalMaterial3Api::class)

package com.dpappdev.uscitizenship.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dpappdev.uscitizenship.R
import com.dpappdev.uscitizenship.ui.theme.USCitizenshipTheme

@Composable
fun PaywallBottomSheet(
    onDismiss: () -> Unit,
    onUpgradeClick: () -> Unit,
) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
                .padding(bottom = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.shooting_star),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(64.dp)
            )
            
            Text(
                text = "Premium Feature",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            
            Text(
                text = "Unlock premium features to access:",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                PremiumFeatureItem("Shuffle all flash cards")
                PremiumFeatureItem("View starred questions")
                PremiumFeatureItem("View starred flash cards")
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Button(
                onClick = onUpgradeClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Upgrade to Premium",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            
            Button(
                onClick = onDismiss,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Maybe Later",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun PremiumFeatureItem(text: String) {
    Text(
        text = "• $text",
        fontSize = 14.sp,
        modifier = Modifier.padding(start = 16.dp),
        color = MaterialTheme.colorScheme.onSurface,
    )
}

@Preview(showBackground = true)
@Composable
fun PaywallBottomSheetPreview() {
    USCitizenshipTheme {
        PaywallBottomSheet(
            onDismiss = {},
            onUpgradeClick = {},
        )
    }
}
