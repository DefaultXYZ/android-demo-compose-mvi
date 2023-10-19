package com.defaultxyz.splash.presentation

import androidx.lifecycle.viewModelScope
import com.defaultxyz.domain.login.IsUserExistsUseCase
import com.defaultxyz.ui.base.BaseIntent
import com.defaultxyz.ui.base.BaseState
import com.defaultxyz.ui.base.BaseViewModel
import com.defaultxyz.utils.di.IODispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val isUserExistsUseCase: IsUserExistsUseCase,
) : BaseViewModel<SplashIntent, SplashState>(SplashState.Init) {
    override fun handleIntent(intent: SplashIntent) {
        when (intent) {
            SplashIntent.LoadLoginState -> {
                viewModelScope.launch(dispatcher) {
                    delay(2000L)
                    if (isUserExistsUseCase()) {
                        SplashState.LoggedInUser.emit()
                    } else {
                        SplashState.NoUserFound.emit()
                    }
                }
            }
        }
    }
}

sealed interface SplashIntent : BaseIntent {
    object LoadLoginState : SplashIntent
}

sealed interface SplashState : BaseState {
    object Init : SplashState
    object Error : SplashState
    object LoggedInUser : SplashState
    object NoUserFound : SplashState
}
