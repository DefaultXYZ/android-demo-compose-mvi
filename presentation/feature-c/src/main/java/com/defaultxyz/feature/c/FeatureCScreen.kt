package com.defaultxyz.feature.c

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.defaultxyz.ui.components.Header
import com.defaultxyz.ui.compose.DefaultPreview

@Composable
fun FeatureCScreen() {
    FeatureCContent()
}

@Composable
internal fun FeatureCContent(modifier: Modifier = Modifier) {
    Column(modifier) {
        Header(stringResource(R.string.feature_c))
    }
}

@DefaultPreview
@Composable
internal fun FeatureCContentPreview() {
    FeatureCContent()
}
