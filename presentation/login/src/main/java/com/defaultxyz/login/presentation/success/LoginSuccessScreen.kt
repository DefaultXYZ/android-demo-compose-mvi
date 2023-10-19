package com.defaultxyz.login.presentation.success

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.defaultxyz.login.R
import com.defaultxyz.ui.components.Header
import com.defaultxyz.ui.compose.DefaultPreview

@Composable
fun LoginSuccessScreen() {
    LoginSuccessContent()
}

@Composable
fun LoginSuccessContent(
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        Header(stringResource(R.string.login_success_title))
    }
}

@DefaultPreview
@Composable
internal fun LoginSuccessContentPreview() {
    LoginSuccessContent()
}
