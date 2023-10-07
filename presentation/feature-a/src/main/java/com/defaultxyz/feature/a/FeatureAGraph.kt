package com.defaultxyz.feature.a

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.defaultxyz.ui.routing.ScreenRoute

fun NavGraphBuilder.featureAGraph(navController: NavController) {
    composable(route = ScreenRoute.FeatureA.route) {
        FeatureAScreen()
    }
}
