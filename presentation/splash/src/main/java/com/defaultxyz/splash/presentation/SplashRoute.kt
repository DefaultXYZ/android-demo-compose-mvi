package com.defaultxyz.splash.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.defaultxyz.splash.R
import com.defaultxyz.ui.compose.DefaultPreview
import com.defaultxyz.ui.routing.AppRoute
import com.defaultxyz.ui.routing.navigate

@Composable
fun SplashRoute(
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    viewModel.handleIntent(SplashIntent.LoadLoginState)

    when (state) {
        SplashState.Init -> Unit
        SplashState.Error -> TODO()
        SplashState.LoggedInUser -> navController.navigate(AppRoute.MainContent)
        SplashState.NoUserFound -> navController.navigate(AppRoute.Login)
    }

    SplashScreen()
}

@Composable
internal fun SplashScreen(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Image(
                painter = painterResource(R.drawable.logo_penguin),
                modifier = Modifier
                    .size(96.dp)
                    .align(Alignment.CenterHorizontally),
                contentDescription = null
            )
            Text(
                stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@DefaultPreview
@Composable
internal fun SplashScreenPreview() {
    SplashScreen()
}
