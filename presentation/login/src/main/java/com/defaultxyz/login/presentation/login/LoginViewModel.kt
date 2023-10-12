package com.defaultxyz.login.presentation.login

import androidx.lifecycle.viewModelScope
import com.defaultxyz.domain.login.GetRandomUserUseCase
import com.defaultxyz.domain.login.SaveUserUseCase
import com.defaultxyz.ui.base.BaseIntent
import com.defaultxyz.ui.base.BaseState
import com.defaultxyz.ui.base.BaseViewModel
import com.defaultxyz.utils.di.IODispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
    private val getRandomUserUseCase: GetRandomUserUseCase,
    private val saveUserUseCase: SaveUserUseCase
) : BaseViewModel<LoginIntent, LoginState>(LoginState.Loading) {
    override fun handleIntent(intent: LoginIntent) {
        when (intent) {
            LoginIntent.GenerateRandomName -> generateRandomName()
            is LoginIntent.SaveUser -> saveUser(intent.firstName, intent.lastName)
        }
    }

    private fun generateRandomName() {
        viewModelScope.launch(ioDispatcher) {
            getRandomUserUseCase().let {
                LoginState.NewNameReceived(firstName = it.first, lastName = it.second)
            }.emit()
        }
    }

    private fun saveUser(firstName: String, lastName: String) {
        viewModelScope.launch(ioDispatcher) {
            saveUserUseCase(firstName to lastName)
            LoginState.LoginSuccessful.emit()
        }
    }

}

sealed class LoginIntent : BaseIntent() {
    object GenerateRandomName : LoginIntent()
    data class SaveUser(
        val firstName: String,
        val lastName: String
    ) : LoginIntent()
}

sealed class LoginState : BaseState() {
    object Loading : LoginState()
    data class NewNameReceived(
        val firstName: String,
        val lastName: String
    ) : LoginState()

    object LoginSuccessful : LoginState()
}
