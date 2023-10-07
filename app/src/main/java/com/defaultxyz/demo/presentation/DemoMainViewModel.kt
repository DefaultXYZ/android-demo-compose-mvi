package com.defaultxyz.demo.presentation

import androidx.lifecycle.ViewModel
import com.defaultxyz.demo.di.IODispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DemoMainViewModel @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _state = MutableStateFlow(DemoMainState())
    val state: StateFlow<DemoMainState> = _state
}

data class DemoMainState(
    val isLoggedIn: Boolean = true
)
