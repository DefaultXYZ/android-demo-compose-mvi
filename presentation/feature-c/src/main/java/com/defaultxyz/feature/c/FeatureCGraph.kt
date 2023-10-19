package com.defaultxyz.feature.c

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.defaultxyz.ui.routing.FeatureRoute.FeatureC

fun NavGraphBuilder.featureCGraph(navController: NavController) {
    navigation(route = FeatureC.route, startDestination = FeatureC.ScreenC1.route) {
        composable(FeatureC.ScreenC1.route) {
            FeatureCRoute()
        }
    }
}
