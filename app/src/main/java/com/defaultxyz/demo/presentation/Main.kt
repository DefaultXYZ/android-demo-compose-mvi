package com.defaultxyz.demo.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.defaultxyz.demo.presentation.bottombar.DemoBottomNavBar
import com.defaultxyz.demo.presentation.navigation.NavigationItem
import com.defaultxyz.demo.presentation.topbar.DemoTopBar
import com.defaultxyz.demo.ui.theme.DemoComposeTheme
import com.defaultxyz.feature.a.featureAGraph
import com.defaultxyz.feature.b.featureBGraph
import com.defaultxyz.feature.c.featureCGraph
import com.defaultxyz.login.LoginScreen
import com.defaultxyz.login.loginGraph
import com.defaultxyz.ui.routing.ScreenRoute

@Composable
fun DemoMainScreen(
    modifier: Modifier = Modifier,
    viewModel: DemoMainViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    DemoComposeTheme {
        Surface(modifier = modifier) {
            if (!state.isLoggedIn) {
                LoginScreen()
            } else {
                DemoMainContent()
            }
        }
    }
}

private val navigationItems = listOf(
    NavigationItem.FeatureA,
    NavigationItem.FeatureB,
    NavigationItem.FeatureC
)

private val startNavigationItem = navigationItems[0]

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoMainContent(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController()
) {
    var topBarTitle: Int by remember {
        mutableIntStateOf(startNavigationItem.title)
    }
    Scaffold(
        modifier = modifier,
        bottomBar = {
            DemoBottomNavBar(
                navController = navHostController,
                navItems = navigationItems,
                onItemSelected = {
                    topBarTitle = it.title
                }
            )
        },
        topBar = {
            DemoTopBar(title = topBarTitle)
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navHostController,
            startDestination = ScreenRoute.FeatureA.route
        ) {
            loginGraph(navHostController)
            featureAGraph(navHostController)
            featureBGraph(navHostController)
            featureCGraph(navHostController)
        }
    }
}
