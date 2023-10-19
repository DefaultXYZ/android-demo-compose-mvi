package com.defaultxyz.feature.a

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.defaultxyz.ui.components.Body
import com.defaultxyz.ui.components.Header
import com.defaultxyz.ui.compose.DefaultPreview

@Composable
fun FeatureAScreen(
    viewModel: FeatureAViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    viewModel.handleIntent(FeatureAIntent.FetchCurrentUser)
    FeatureAContent(state = state)
}

@Composable
internal fun FeatureAContent(
    modifier: Modifier = Modifier,
    state: FeatureAState = FeatureAState()
) {
    Column(modifier) {
        Header(stringResource(R.string.feature_a))
        Body(state.username.orEmpty())
    }
}

@DefaultPreview
@Composable
internal fun FeatureAContentPreview() {
    FeatureAContent()
}
