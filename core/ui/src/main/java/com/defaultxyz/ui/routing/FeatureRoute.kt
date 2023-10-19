package com.defaultxyz.ui.routing

sealed class FeatureRoute(override val route: String): NavRoute {
    object FeatureA : FeatureRoute("feature-a")

    object FeatureB : FeatureRoute("feature-b") {
        object ScreenB1 : FeatureRoute("screen-b-1")
    }

    object FeatureC : FeatureRoute("feature-c") {
        object ScreenC1 : FeatureRoute("screen-c-1")
    }
}
