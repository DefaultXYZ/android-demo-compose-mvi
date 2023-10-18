package com.defaultxyz.ui.routing

sealed class ParentScreenRoute(val route: String) {
    object Splash : ParentScreenRoute("splash")
    object Login : ParentScreenRoute("login") {
        object StartLogin : ParentScreenRoute("start-login")
        object LoginSuccess : ParentScreenRoute("login-success")
    }
    object MainContent : ParentScreenRoute("main")
}
