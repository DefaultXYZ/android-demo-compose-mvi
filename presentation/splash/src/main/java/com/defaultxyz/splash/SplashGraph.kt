package com.defaultxyz.splash

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.defaultxyz.splash.presentation.SplashRoute
import com.defaultxyz.ui.routing.AppRoute
import com.defaultxyz.ui.routing.composable

fun NavGraphBuilder.splashGraph(navController: NavController) {
    composable(route = AppRoute.Splash) {
        SplashRoute(navController = navController)
    }
}
