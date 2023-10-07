package com.defaultxyz.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.defaultxyz.ui.routing.ScreenRoute.Login

fun NavGraphBuilder.loginGraph(navController: NavController) {
    navigation(route = Login.route, startDestination = Login.LoginSuccess.route) {
        composable(route = Login.StartLogin.route) {
            LoginScreen()
        }
        composable(route = Login.LoginSuccess.route) {
            LoginSuccessScreen()
        }
    }
}
