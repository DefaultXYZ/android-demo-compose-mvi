package com.defaultxyz.feature.a

import androidx.lifecycle.viewModelScope
import com.defaultxyz.domain.login.GetCurrentUserUseCase
import com.defaultxyz.ui.base.BaseIntent
import com.defaultxyz.ui.base.BaseState
import com.defaultxyz.ui.base.BaseViewModel
import com.defaultxyz.utils.di.IODispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeatureAViewModel @Inject constructor(
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
) : BaseViewModel<FeatureAIntent, FeatureAState>(FeatureAState.Init) {
    override fun handleIntent(intent: FeatureAIntent) {
        when (intent) {
            FeatureAIntent.FetchCurrentUser -> {
                viewModelScope.launch(ioDispatcher) {
                    with(getCurrentUserUseCase()) {
                        FeatureAState.UsernameReceived("$firstName $lastName")
                    }.emit()
                }
            }
        }
    }
}

sealed interface FeatureAIntent : BaseIntent {
    object FetchCurrentUser : FeatureAIntent
}

sealed interface FeatureAState : BaseState {
    object Init : FeatureAState
    object Error : FeatureAState
    data class UsernameReceived(
        val username: String,
    ) : FeatureAState
}
