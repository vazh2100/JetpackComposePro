package vazh2100.vk_client.presentation.screens.feed

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import vazh2100.vk_client.domain.entities.FeedPost

@Suppress("PropertyName")
open class FeedState : ViewModel() {

    protected val _feedPosts = mutableListOf<MutableState<FeedPost>>()
    val feedPosts: List<State<FeedPost>> = _feedPosts
    protected var _lastPost: String? = null

    val listRecomposeNeeded = mutableIntStateOf(0)

    protected val _nextLoading = MutableStateFlow(false)
    val nextLoading = _nextLoading.asStateFlow()
}