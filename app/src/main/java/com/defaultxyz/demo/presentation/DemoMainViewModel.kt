package com.defaultxyz.demo.presentation

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
class DemoMainViewModel @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val isUserExistsUseCase: IsUserExistsUseCase
) : BaseViewModel<DemoMainIntent, DemoMainState>(DemoMainState.Loading) {
    override fun handleIntent(intent: DemoMainIntent) {
        when (intent) {
            DemoMainIntent.LoadLoginState -> {
                viewModelScope.launch(dispatcher) {
                    if (isUserExistsUseCase()) {
                        mutableState.emit(DemoMainState.LoggedIn)
                    } else {
                        mutableState.emit(DemoMainState.NoUserExists)
                    }
                }
            }
        }
    }
}

sealed class DemoMainIntent : BaseIntent() {
    object LoadLoginState : DemoMainIntent()
}

sealed class DemoMainState : BaseState() {
    object Loading : DemoMainState()
    object LoggedIn : DemoMainState()
    object NoUserExists : DemoMainState()
}
