package com.defaultxyz.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.defaultxyz.login.presentation.login.LoginScreen
import com.defaultxyz.login.presentation.success.LoginSuccessScreen
import com.defaultxyz.ui.routing.ParentScreenRoute.Login

fun NavGraphBuilder.loginGraph(navController: NavController) {
    navigation(route = Login.route, startDestination = Login.StartLogin.route) {
        composable(Login.StartLogin.route) {
            LoginScreen(onLoginSuccess = {
                navController.navigate(Login.LoginSuccess.route)
            })
        }
        composable(Login.LoginSuccess.route) {
            LoginSuccessScreen()
        }
    }
}
