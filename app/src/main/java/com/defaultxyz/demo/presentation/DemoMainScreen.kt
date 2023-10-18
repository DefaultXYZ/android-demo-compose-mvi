package com.defaultxyz.demo.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.defaultxyz.demo.presentation.bottombar.DemoBottomNavBar
import com.defaultxyz.demo.presentation.navigation.NavigationItem
import com.defaultxyz.demo.presentation.topbar.DemoTopBar
import com.defaultxyz.demo.ui.theme.DemoComposeTheme
import com.defaultxyz.feature.a.featureAGraph
import com.defaultxyz.feature.b.featureBGraph
import com.defaultxyz.feature.c.featureCGraph
import com.defaultxyz.localisation.R
import com.defaultxyz.login.loginGraph
import com.defaultxyz.ui.routing.ParentScreenRoute
import com.defaultxyz.ui.routing.ScreenRoute
import kotlinx.coroutines.delay

@Composable
fun DemoMainScreen(
    modifier: Modifier = Modifier
) {
    DemoComposeTheme {
        Surface(modifier) {
            DemoParentNavigation()
        }
    }
}

@Composable
fun DemoParentNavigation() {
    val parentNavController = rememberNavController()
    NavHost(
        navController = parentNavController,
        startDestination = ParentScreenRoute.Splash.route
    ) {
        composable(ParentScreenRoute.Splash.route) {
            SplashScreen(navController = parentNavController)
        }
        loginGraph(parentNavController)
        composable(ParentScreenRoute.MainContent.route) {
            DemoMainContent()
        }
    }
}

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    viewModel: DemoMainViewModel = hiltViewModel(),
    navController: NavController
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel.state) {
        delay(2000L)
        viewModel.handleIntent(DemoMainIntent.LoadLoginState)
    }

    if (state.isLoggedIn == true) {
        navController.navigate(ParentScreenRoute.MainContent.route)
    } else if (state.isLoggedIn == false) {
        navController.navigate(ParentScreenRoute.Login.route)
    }

    Column(modifier = modifier.fillMaxHeight()) {
        Box {
            Text(stringResource(R.string.app_name), modifier = Modifier.align(Alignment.Center))
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
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
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
            featureAGraph(navController)
            featureBGraph(navController)
            featureCGraph(navController)
        }
    }
}
