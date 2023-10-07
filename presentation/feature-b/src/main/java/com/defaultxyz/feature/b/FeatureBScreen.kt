package com.defaultxyz.feature.b

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FeatureBScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text("Feature B")
    }
}
