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
    private val saveUserUseCase: SaveUserUseCase,
) : BaseViewModel<LoginIntent, LoginState>(LoginState.Init) {
    override fun handleIntent(intent: LoginIntent) {
        when (intent) {
            LoginIntent.GenerateRandomName -> generateRandomName()
            is LoginIntent.SaveUser -> saveUser(intent.firstName, intent.lastName)
        }
    }

    private fun generateRandomName() {
        viewModelScope.launch(ioDispatcher) {
            getRandomUserUseCase().let {
                LoginState.NewNameGenerated(it.first, it.second)
            }.emit()
        }
    }

    private fun saveUser(firstName: String, lastName: String) {
        viewModelScope.launch(ioDispatcher) {
            saveUserUseCase(firstName to lastName)
            LoginState.LoginFinished.emit()
        }
    }

}

sealed interface LoginIntent : BaseIntent {
    object GenerateRandomName : LoginIntent
    data class SaveUser(
        val firstName: String,
        val lastName: String,
    ) : LoginIntent
}

sealed interface LoginState : BaseState {
    object Init : LoginState

    object Error : LoginState

    data class NewNameGenerated(
        val firstName: String,
        val lastName: String,
    ) : LoginState {
        val username: String
            get() = listOfNotNull(firstName, lastName).joinToString(" ")
    }

    object LoginFinished : LoginState
}
