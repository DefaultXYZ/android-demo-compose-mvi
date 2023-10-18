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
) : BaseViewModel<LoginIntent, LoginState>(LoginState()) {
    override fun handleIntent(intent: LoginIntent) {
        when (intent) {
            LoginIntent.GenerateRandomName -> generateRandomName()
            is LoginIntent.SaveUser -> saveUser(intent.firstName, intent.lastName)
        }
    }

    private fun generateRandomName() {
        viewModelScope.launch(ioDispatcher) {
            getRandomUserUseCase().let {
                stateValue.copy(
                    firstName = it.first,
                    lastName = it.second
                )
            }.emit()
        }
    }

    private fun saveUser(firstName: String, lastName: String) {
        viewModelScope.launch(ioDispatcher) {
            saveUserUseCase(firstName to lastName)
            stateValue.copy(
                loginSuccessful = true
            ).emit()
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

data class LoginState(
    val firstName: String? = null,
    val lastName: String? = null,
    val loginSuccessful: Boolean? = null
) : BaseState {
    val username: String
        get() = listOfNotNull(firstName, lastName).joinToString(" ")

    val hasUsername: Boolean
        get() = !firstName.isNullOrBlank() && !lastName.isNullOrBlank()
}
