package com.defaultxyz.demo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.defaultxyz.domain.login.GetUserLoginUseCase
import com.defaultxyz.utils.di.IODispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DemoMainViewModel @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val getUserLoginUseCase: GetUserLoginUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<DemoMainState>(DemoMainState.Loading)
    val state: StateFlow<DemoMainState> = _state

    fun onReceiveIntent(intent: DemoMainIntent) {
        when (intent) {
            DemoMainIntent.LoadLoginState -> {
                viewModelScope.launch(dispatcher) {
                    if (getUserLoginUseCase.get()) {
                        _state.emit(DemoMainState.LoggedIn)
                    } else {
                        _state.emit(DemoMainState.NoUserExists)
                    }
                }
            }
        }
    }
}

sealed class DemoMainIntent {
    object LoadLoginState: DemoMainIntent()
}

sealed class DemoMainState {
    object Loading : DemoMainState()
    object LoggedIn : DemoMainState()
    object NoUserExists : DemoMainState()
}
