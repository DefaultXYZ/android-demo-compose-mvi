package com.defaultxyz.feature.c

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.defaultxyz.localisation.R
import com.defaultxyz.ui.components.Header

@Composable
fun FeatureCScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Header(stringResource(R.string.feature_c))
    }
}
