package com.defaultxyz.login.presentation.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.defaultxyz.login.R
import com.defaultxyz.ui.compose.DefaultPreview
import com.defaultxyz.ui.routing.AppRoute
import com.defaultxyz.ui.routing.navigate

@Composable
fun LoginRoute(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LoginScreen(
        state = state,
        onLoginClick = viewModel::handleIntent,
        onGenerateRandomName = viewModel::handleIntent,
        onLoginSuccess = { navController.navigate(AppRoute.Login.LoginSuccess) }
    )
}

@Composable
internal fun LoginScreen(
    state: LoginState,
    modifier: Modifier = Modifier,
    onLoginClick: (LoginIntent) -> Unit = {},
    onGenerateRandomName: (LoginIntent) -> Unit = {},
    onLoginSuccess: () -> Unit = {},
) {
    if (state is LoginState.LoginFinished) {
        onLoginSuccess()
    }
    Box(modifier.fillMaxSize()) {
        Column(
            Modifier
                .padding(16.dp)
                .align(Alignment.Center)
        ) {
            val centerModifier = Modifier.align(Alignment.CenterHorizontally)
            val buttonModifier = centerModifier.fillMaxWidth(.5f)
            Text(
                stringResource(R.string.login_screen),
                modifier = centerModifier,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.fillMaxHeight(.5f))
            Text(
                (state as? LoginState.NewNameGenerated)?.username.orEmpty(),
                modifier = centerModifier,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.fillMaxHeight(.5f))
            Button(
                modifier = buttonModifier,
                onClick = {
                    onGenerateRandomName(LoginIntent.GenerateRandomName)
                }
            ) {
                Text(stringResource(R.string.login_generate_new_name))
            }
            Button(
                modifier = buttonModifier,
                enabled = state is LoginState.NewNameGenerated,
                onClick = {
                    if (state is LoginState.NewNameGenerated) {
                        onLoginClick(LoginIntent.SaveUser(state.firstName, state.lastName))
                    }
                }
            ) {
                Text(stringResource(R.string.login_button_login))
            }
        }
    }
}

@DefaultPreview
@Composable
internal fun LoginScreenPreview() {
    LoginScreen(LoginState.NewNameGenerated("Test", "Test"))
}
