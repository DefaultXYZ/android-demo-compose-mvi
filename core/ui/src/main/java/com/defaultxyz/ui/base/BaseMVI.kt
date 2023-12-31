package com.defaultxyz.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<I : BaseIntent, S : BaseState>(
    initialState: S,
) : ViewModel() {
    private val mutableState: MutableStateFlow<S> = MutableStateFlow(initialState)
    val state: StateFlow<S> = mutableState

    abstract fun handleIntent(intent: I)

    protected suspend fun S.emit() {
        mutableState.emit(this)
    }
}

interface BaseIntent

interface BaseState
