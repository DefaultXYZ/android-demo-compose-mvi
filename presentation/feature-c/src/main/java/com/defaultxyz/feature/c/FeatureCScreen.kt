package com.defaultxyz.feature.c

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FeatureCScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text("Feature C")
    }
}
