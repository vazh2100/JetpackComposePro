package vazh2100.vk_client.l_comments.screens.feed

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import vazh2100.vk_client.j_lazy_column.entities.FeedPost

class FeedViewModel : ViewModel() {

    private val _feedPosts = mutableListOf<MutableState<FeedPost>>().apply {
        repeat(100) { add(mutableStateOf(FeedPost(id = it))) }
    }

    val feedPosts: List<State<FeedPost>> = _feedPosts
    val recomposeList = mutableIntStateOf(0)

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
