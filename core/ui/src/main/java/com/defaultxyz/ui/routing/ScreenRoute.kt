package com.defaultxyz.ui.routing

sealed class ScreenRoute(val route: String) {
    object Login : ScreenRoute("/login") {
        object StartLogin : ScreenRoute("/start-login")
        object LoginSuccess : ScreenRoute("/login-success")
    }

    object FeatureA : ScreenRoute("/feature-a")

    object FeatureB : ScreenRoute("/feature-b") {
        object ScreenB1 : ScreenRoute("/screen-b-1")
    }

    object FeatureC : ScreenRoute("/feature-c") {
        object ScreenC1 : ScreenRoute("/screen-c-1")
    }
}
