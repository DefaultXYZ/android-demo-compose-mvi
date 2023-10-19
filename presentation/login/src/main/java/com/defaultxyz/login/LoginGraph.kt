package com.defaultxyz.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.defaultxyz.login.presentation.login.LoginRoute
import com.defaultxyz.login.presentation.success.LoginSuccessRoute
import com.defaultxyz.ui.routing.AppRoute.Login
import com.defaultxyz.ui.routing.composable
import com.defaultxyz.ui.routing.navigation

fun NavGraphBuilder.loginGraph(navController: NavController) {
    navigation(route = Login, startDestination = Login.StartLogin) {
        composable(Login.StartLogin) {
            LoginRoute(navController)
        }
        composable(Login.LoginSuccess) {
            LoginSuccessRoute(navController)
        }
    }
}
