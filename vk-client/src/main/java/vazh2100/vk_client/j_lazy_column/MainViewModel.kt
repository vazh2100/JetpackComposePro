package vazh2100.vk_client.j_lazy_column

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import vazh2100.vk_client.j_lazy_column.entities.FeedPost

class MainViewModel : ViewModel() {
    val feedPosts = mutableListOf<MutableState<FeedPost>>().apply {
        repeat(100) { add(mutableStateOf(FeedPost(id = it))) }
    }
    val recomposeList = mutableIntStateOf(0)

    fun onViewsPress(index: Int) {
        val postState = feedPosts[index]
        val post = postState.value
        postState.value = post.copy(statistics = post.statistics.copy(views = post.views + 1))
    }

    fun onSharesPress(index: Int) {
        val postState = feedPosts[index]
        val post = postState.value
        postState.value = post.copy(statistics = post.statistics.copy(shares = post.shares + 1))
    }

    fun onCommentsPress(index: Int) {
        val postState = feedPosts[index]
        val post = postState.value
        postState.value = post.copy(statistics = post.statistics.copy(comments = post.comments + 1))
    }

    fun onLikesPress(index: Int) {
        val postState = feedPosts[index]
        val post = postState.value
        postState.value = post.copy(statistics = post.statistics.copy(likes = post.likes + 1))
    }

    fun onSwipe(index: Int) = run { feedPosts.removeAt(index); recomposeList.value += 1 }
}
