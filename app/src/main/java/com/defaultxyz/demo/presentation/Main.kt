package com.defaultxyz.demo.presentation

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.defaultxyz.demo.ui.theme.DemoComposeTheme

@Composable
fun DemoMainScreen(
    modifier: Modifier = Modifier,
    viewModel: DemoMainViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    DemoComposeTheme {
        Surface(modifier = modifier) {
            Greeting(name = state.name)
        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    name: String
) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemoComposeTheme {
        Greeting(name = "Android")
    }
}
