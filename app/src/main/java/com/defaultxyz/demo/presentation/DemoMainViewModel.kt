package com.defaultxyz.demo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.defaultxyz.demo.di.IODispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DemoMainViewModel @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _state = MutableStateFlow(DemoMainState())
    val state: StateFlow<DemoMainState> = _state

    init {
        viewModelScope.launch(dispatcher) {
            _state.emit(DemoMainState("Test"))
        }
    }
}

data class DemoMainState(
    val name: String = ""
)
