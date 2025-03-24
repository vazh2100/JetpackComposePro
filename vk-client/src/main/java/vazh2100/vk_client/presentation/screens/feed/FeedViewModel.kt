package vazh2100.vk_client.presentation.screens.feed

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import vazh2100.vk_client.domain.entities.FeedPost
import vazh2100.vk_client.domain.usecases.GetFeed
import vazh2100.vk_client.domain.usecases.Like
import vazh2100.vk_client.domain.usecases.Unlike

class FeedViewModel : ViewModel() {
    private val getRecommendations = GetFeed
    private val like = Like
    private val unlike = Unlike

    private var startFrom: String? = null
    private val _feedPosts = mutableListOf<MutableState<FeedPost>>()
    val feedPosts: List<State<FeedPost>> = _feedPosts

    private val _nextLoading = MutableStateFlow(false)
    val nextLoading = _nextLoading.asStateFlow()

    val recomposeList = mutableIntStateOf(0)

    init {
        loadFeed()
    }

    fun loadFeed() = viewModelScope.launch {
        _nextLoading.value = true
        val (newsFeed, nextFrom) = getRecommendations(startFrom)
        startFrom = nextFrom
        _feedPosts.addAll(newsFeed.map { mutableStateOf(it) })
        recomposeList.intValue++
        _nextLoading.value = false
    }

    fun onViewsPress(index: Int) {
        val postState = _feedPosts[index]
        val post = postState.value
        postState.value = post.copy(statistics = post.statistics.copy(views = post.views + 1))
    }

    fun onSharesPress(index: Int) {

        val postState = _feedPosts[index]
        val post = postState.value
        postState.value = post.copy(statistics = post.statistics.copy(shares = post.shares + 1))
    }

    fun onLikesPress(index: Int) {
        viewModelScope.launch {
            val postState = _feedPosts[index]
            val post = postState.value
            if (!post.statistics.isLiked) {
                like(post)
                postState.value = post.copy(statistics = post.statistics.copy(likes = post.likes + 1, isLiked = true))
            } else {
                unlike(post)
                postState.value = post.copy(statistics = post.statistics.copy(likes = post.likes - 1, isLiked = false))
            }

        }
    }

    fun onSwipe(index: Int) = run { _feedPosts.removeAt(index); recomposeList.intValue += 1 }
}
