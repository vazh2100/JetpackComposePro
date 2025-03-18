package vazh2100.vk_client.l_comments

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import vazh2100.vk_client.j_lazy_column.entities.FeedPost
import vazh2100.vk_client.l_comments.screens.HomeScreenState

class HomeViewModel : ViewModel() {

    private val feedPosts = mutableListOf<MutableState<FeedPost>>().apply {
        repeat(100) { add(mutableStateOf(FeedPost(id = it))) }
    }

    private val _screenState = MutableStateFlow<HomeScreenState>(HomeScreenState.Posts(feedPosts))
    val screenState = _screenState.asStateFlow()

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
