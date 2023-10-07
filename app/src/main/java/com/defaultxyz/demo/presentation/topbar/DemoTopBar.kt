package com.defaultxyz.demo.presentation.topbar

import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.defaultxyz.demo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoTopBar(
    modifier: Modifier = Modifier,
    @StringRes title: Int = R.string.default_toolbar_title
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(stringResource(title)) }
    )
}
