package com.defaultxyz.feature.b

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.defaultxyz.ui.components.Header
import com.defaultxyz.ui.compose.DefaultPreview

@Composable
fun FeatureBScreen() {
    FeatureBContent()
}

@Composable
internal fun FeatureBContent(modifier: Modifier = Modifier) {
    Column(modifier) {
        Header(stringResource(R.string.feature_b))
    }
}

@DefaultPreview
@Composable
internal fun FeatureBContentPreview() {
    FeatureBContent()
}
