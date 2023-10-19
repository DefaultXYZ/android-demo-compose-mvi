package com.defaultxyz.login.presentation.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.defaultxyz.login.R
import com.defaultxyz.ui.compose.DefaultPreview

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onLoginSuccess: () -> Unit = {},
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LoginContent(
        state = state,
        onLoginClick = {
            viewModel.handleIntent(
                LoginIntent.SaveUser(
                    state.firstName.orEmpty(),
                    state.lastName.orEmpty()
                )
            )
        },
        onGenerateRandomName = {
            viewModel.handleIntent(LoginIntent.GenerateRandomName)
        },
        onLoginSuccess = onLoginSuccess
    )
}

@Composable
internal fun LoginContent(
    modifier: Modifier = Modifier,
    state: LoginState = LoginState(),
    onLoginClick: () -> Unit = {},
    onGenerateRandomName: () -> Unit = {},
    onLoginSuccess: () -> Unit = {}
) {
    Column(modifier) {
        SideEffect {
            if (state.loginSuccessful == true) {
                onLoginSuccess()
            }
        }
        Text(
            stringResource(R.string.login_screen),
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            state.username,
            style = MaterialTheme.typography.bodyMedium
        )
        Button(onClick = onGenerateRandomName) {
            Text(stringResource(R.string.login_generate_new_name))
        }

        Button(onClick = {
            if (state.hasUsername) {
                onLoginClick()
            }
        }) {
            Text(stringResource(R.string.login_button_login))
        }
    }
}

@DefaultPreview
@Composable
internal fun LoginContentPreview() {
    LoginContent()
}
