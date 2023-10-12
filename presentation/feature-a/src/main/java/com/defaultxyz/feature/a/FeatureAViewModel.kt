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
    private val getCurrentUserUseCase: GetCurrentUserUseCase
) : BaseViewModel<FeatureAIntent, FeatureAState>(FeatureAState.OnInit) {
    override fun handleIntent(intent: FeatureAIntent) {
        when (intent) {
            FeatureAIntent.FetchCurrentUser -> {
                viewModelScope.launch(ioDispatcher) {
                    with(getCurrentUserUseCase()) {
                        FeatureAState.UserReceived("$firstName $lastName")
                    }.emit()
                }
            }
        }
    }
}

sealed class FeatureAIntent : BaseIntent() {
    object FetchCurrentUser : FeatureAIntent()
}

sealed class FeatureAState : BaseState() {
    object OnInit : FeatureAState()
    data class UserReceived(val username: String) : FeatureAState()
}
