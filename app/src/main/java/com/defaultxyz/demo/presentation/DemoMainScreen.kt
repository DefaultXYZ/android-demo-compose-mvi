package com.defaultxyz.demo.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
import com.defaultxyz.login.presentation.login.LoginScreen
import com.defaultxyz.ui.routing.ScreenRoute

@Composable
fun DemoMainScreen(
    modifier: Modifier = Modifier,
    viewModel: DemoMainViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val state by viewModel.state.collectAsStateWithLifecycle()
    viewModel.handleIntent(DemoMainIntent.LoadLoginState)
    DemoComposeTheme {
        Surface(modifier) {
            if (state is DemoMainState.LoggedIn) {
                DemoMainContent(navController)
            } else if (state is DemoMainState.NoUserExists) {
                LoginScreen(onLoginSuccess = {
                    viewModel.handleIntent(DemoMainIntent.LoadLoginState)
                })
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
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    var topBarTitle: Int by remember {
        mutableIntStateOf(startNavigationItem.title)
    }
    Scaffold(
        modifier = modifier,
        bottomBar = {
            DemoBottomNavBar(
                navController = navController,
                navItems = navigationItems,
                onItemSelected = {
                    topBarTitle = it.title
                }
            )
        },
        topBar = {
            DemoTopBar(title = stringResource(topBarTitle))
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = ScreenRoute.FeatureA.route
        ) {
//            loginGraph(navController)
            featureAGraph(navController)
            featureBGraph(navController)
            featureCGraph(navController)
        }
    }
}
