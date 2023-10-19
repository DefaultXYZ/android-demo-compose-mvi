package com.defaultxyz.login.presentation.success

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.defaultxyz.login.R
import com.defaultxyz.ui.compose.DefaultPreview
import com.defaultxyz.ui.routing.AppRoute
import com.defaultxyz.ui.routing.navigate

@Composable
fun LoginSuccessRoute(
    navController: NavController,
) {
    LoginSuccessScreen(
        onProceedNext = { navController.navigate(AppRoute.MainContent) }
    )
}

@Composable
fun LoginSuccessScreen(
    modifier: Modifier = Modifier,
    onProceedNext: () -> Unit = {},
) {
    Box(modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                stringResource(R.string.login_success_title),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.fillMaxHeight(.5f))
            Button(
                onClick = onProceedNext,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.login_success_proceed))
            }
        }
    }
}

@DefaultPreview
@Composable
internal fun LoginSuccessScreenPreview() {
    LoginSuccessScreen()
}
