package vazh2100.vk_client.presentation.screens.feed

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vazh2100.vk_client.domain.usecases.GetFeed
import vazh2100.vk_client.domain.usecases.IgnorePost
import vazh2100.vk_client.domain.usecases.Like
import vazh2100.vk_client.domain.usecases.Unlike

class FeedViewModel : FeedState() {
    private val getRecommendations = GetFeed
    private val like = Like
    private val unlike = Unlike
    private val ignorePost = IgnorePost

    fun onFeedEndReached() = viewModelScope.launch {
        _nextLoading.value = true
        _nextError.value = false
        getRecommendations(_lastPost).onSuccess { value ->
            val (newsFeed, lastPost) = value
            _lastPost = lastPost
            _feedPosts.addAll(newsFeed.map { mutableStateOf(it) })
            listRecomposeNeeded.intValue++
        }.onFailure {
            _nextError.value = true
        }
        _nextLoading.value = false
    }

    fun onLikesPress(index: Int) = viewModelScope.launch {
        val postState = _feedPosts[index]
        val post = postState.value
        if (!post.statistics.isLiked) {
            like(post).onSuccess {
                postState.value = post.copy(statistics = post.statistics.copy(likes = post.likes + 1, isLiked = true))
            }
        } else {
            unlike(post).onSuccess {
                postState.value = post.copy(statistics = post.statistics.copy(likes = post.likes - 1, isLiked = false))
            }
        }

    }

    fun onSwipe(index: Int) = viewModelScope.launch {
        val post = _feedPosts[index].value
        ignorePost(post).onSuccess {
            _feedPosts.removeAt(index)
        }
        listRecomposeNeeded.intValue++
    }
}
