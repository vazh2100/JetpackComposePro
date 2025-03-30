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
        val (newsFeed, lastPost) = getRecommendations(_lastPost)
        _lastPost = lastPost
        _feedPosts.addAll(newsFeed.map { mutableStateOf(it) })
        listRecomposeNeeded.intValue++
        _nextLoading.value = false
    }

    fun onLikesPress(index: Int) = viewModelScope.launch {
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

    fun onSwipe(index: Int) = viewModelScope.launch {
        val post = _feedPosts[index].value
        ignorePost(post)
        _feedPosts.removeAt(index)
        listRecomposeNeeded.intValue += 1
    }
}
