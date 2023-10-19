package com.defaultxyz.splash

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.defaultxyz.splash.presentation.SplashScreen
import com.defaultxyz.ui.routing.ParentScreenRoute

fun NavGraphBuilder.splashGraph(navController: NavController) {
    composable(route = ParentScreenRoute.Splash.route) {
        SplashScreen(navController = navController)
    }
}
