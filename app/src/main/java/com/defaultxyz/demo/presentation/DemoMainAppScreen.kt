package com.defaultxyz.demo.presentation

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.defaultxyz.demo.ui.theme.DemoComposeTheme
import com.defaultxyz.login.loginGraph
import com.defaultxyz.splash.splashGraph
import com.defaultxyz.ui.routing.AppRoute
import com.defaultxyz.ui.routing.composable

@Composable
fun DemoMainAppScreen(
    modifier: Modifier = Modifier
) {
    DemoComposeTheme {
        Surface(modifier) {
            DemoParentNavigation()
        }
    }
}

@Composable
fun DemoParentNavigation() {
    val parentNavController = rememberNavController()
    NavHost(
        navController = parentNavController,
        startDestination = AppRoute.Splash.route
    ) {
        splashGraph(parentNavController)
        loginGraph(parentNavController)
        composable(AppRoute.MainContent) {
            DemoMainRoute()
        }
    }
}
