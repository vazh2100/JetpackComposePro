package vazh2100.vk_client.l_comments

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import vazh2100.vk_client.j_lazy_column.entities.FeedPost
import vazh2100.vk_client.l_comments.entities.Comment
import vazh2100.vk_client.l_comments.screens.HomeScreenState

class HomeViewModel : ViewModel() {

    private val feedPosts = mutableListOf<MutableState<FeedPost>>().apply {
        repeat(100) { add(mutableStateOf(FeedPost(id = it))) }
    }
    private val comments = buildList { repeat(10) { add(Comment(it)) } }

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

    private lateinit var savedState: HomeScreenState
    fun onCommentsPress(index: Int) {
        savedState = _screenState.value
        val feedPost = feedPosts[index].value
        _screenState.value = HomeScreenState.Comments(feedPost = feedPost, comments = comments)
    }

    fun onCommentsClose() = run { _screenState.value = savedState }

    fun onLikesPress(index: Int) {
        val postState = feedPosts[index]
        val post = postState.value
        postState.value = post.copy(statistics = post.statistics.copy(likes = post.likes + 1))
    }

    fun onSwipe(index: Int) = run { feedPosts.removeAt(index); recomposeList.value += 1 }
}
