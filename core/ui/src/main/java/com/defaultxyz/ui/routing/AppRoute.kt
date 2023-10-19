package com.defaultxyz.ui.routing

sealed class AppRoute(override val route: String): NavRoute {
    object Splash : AppRoute("splash")
    object Login : AppRoute("login") {
        object StartLogin : AppRoute("start-login")
        object LoginSuccess : AppRoute("login-success")
    }
    object MainContent : AppRoute("main")
}
