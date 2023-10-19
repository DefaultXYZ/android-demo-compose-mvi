package com.defaultxyz.splash.presentation

import androidx.lifecycle.viewModelScope
import com.defaultxyz.domain.login.IsUserExistsUseCase
import com.defaultxyz.ui.base.BaseIntent
import com.defaultxyz.ui.base.BaseState
import com.defaultxyz.ui.base.BaseViewModel
import com.defaultxyz.utils.di.IODispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val isUserExistsUseCase: IsUserExistsUseCase
) : BaseViewModel<SplashIntent, SplashState>(SplashState()) {
    override fun handleIntent(intent: SplashIntent) {
        when (intent) {
            SplashIntent.LoadLoginState -> {
                viewModelScope.launch(dispatcher) {
                    if (isUserExistsUseCase()) {
                        stateValue.copy(
                            isLoggedIn = true
                        ).emit()
                    } else {
                        stateValue.copy(
                            isLoggedIn = false
                        ).emit()
                    }
                }
            }
        }
    }
}

sealed class SplashIntent : BaseIntent() {
    object LoadLoginState : SplashIntent()
}

data class SplashState(
    val isLoggedIn: Boolean? = null
) : BaseState
