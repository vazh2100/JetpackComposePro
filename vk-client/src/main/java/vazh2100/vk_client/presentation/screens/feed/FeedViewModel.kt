package vazh2100.vk_client.presentation.screens.feed

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vk.id.VKID
import kotlinx.coroutines.launch
import vazh2100.vk_client.data.mappers.NewsFeedMapper.toFeedPosts
import vazh2100.vk_client.data.network.ApiFactory.apiService
import vazh2100.vk_client.entities.FeedPost

class FeedViewModel : ViewModel() {

    private val _feedPosts = mutableListOf<MutableState<FeedPost>>()

    val feedPosts: List<State<FeedPost>> = _feedPosts
    val recomposeList = mutableIntStateOf(0)

    init {
        onStart()
    }

    private fun onStart() = viewModelScope.launch {
        val feedPosts = apiService.feed(VKID.instance.accessToken?.token ?: "").toFeedPosts()
        val newFeed = feedPosts.map { mutableStateOf(it) }
        _feedPosts.addAll(newFeed)
        recomposeList.intValue++
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
        val postState = _feedPosts[index]
        val post = postState.value
        postState.value = post.copy(statistics = post.statistics.copy(likes = post.likes + 1))
    }

    fun onSwipe(index: Int) = run { _feedPosts.removeAt(index); recomposeList.value += 1 }
}
