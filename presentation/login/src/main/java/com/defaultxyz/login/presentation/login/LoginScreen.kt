package com.defaultxyz.login.presentation.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.defaultxyz.localisation.R
import com.defaultxyz.ui.components.Body
import com.defaultxyz.ui.components.Header

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Column(modifier) {
        SideEffect {
            if (state == LoginState.LoginSuccessful) {
                onLoginSuccess()
            }
        }
        Header(stringResource(R.string.login_screen))

        (state as? LoginState.NewNameReceived)?.apply {
            Body("$firstName $lastName")
        }

        Button(onClick = {
            viewModel.handleIntent(LoginIntent.GenerateRandomName)
        }) {
            Text(stringResource(R.string.login_generate_new_name))
        }

        Button(onClick = {
            (state as? LoginState.NewNameReceived)?.apply {
                viewModel.handleIntent(LoginIntent.SaveUser(firstName, lastName))
            }
        }) {
            Text(stringResource(R.string.login_button_login))
        }
    }
}
