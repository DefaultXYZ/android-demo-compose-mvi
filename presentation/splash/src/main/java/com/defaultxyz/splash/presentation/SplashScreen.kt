package com.defaultxyz.splash.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.defaultxyz.ui.routing.ParentScreenRoute
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel.state) {
        delay(2000L)
        viewModel.handleIntent(SplashIntent.LoadLoginState)
    }

    if (state.isLoggedIn == true) {
        navController.navigate(ParentScreenRoute.MainContent.route)
    } else if (state.isLoggedIn == false) {
        navController.navigate(ParentScreenRoute.Login.route)
    }

    SplashContent()
}

@Composable
internal fun SplashContent(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
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
internal fun SplashContentPreview() {
    SplashContent()
}
