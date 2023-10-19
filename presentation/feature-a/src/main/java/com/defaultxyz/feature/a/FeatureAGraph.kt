package com.defaultxyz.feature.a

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.defaultxyz.ui.routing.FeatureRoute
import com.defaultxyz.ui.routing.composable

fun NavGraphBuilder.featureAGraph(navController: NavController) {
    composable(route = FeatureRoute.FeatureA) {
        FeatureARoute()
    }
}
