package com.defaultxyz.feature.b

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.defaultxyz.localisation.R
import com.defaultxyz.ui.components.Header

@Composable
fun FeatureBScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Header(stringResource(R.string.feature_b))
    }
}
