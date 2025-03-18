package vazh2100.vk_client.l_comments.screens.comments

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import vazh2100.vk_client.j_lazy_column.entities.FeedPost
import vazh2100.vk_client.l_comments.entities.Comment

class CommentsViewModel : ViewModel() {
    private val _comments = MutableStateFlow(buildList { repeat(10) { add(Comment(it)) } })
    val comments = _comments.asStateFlow()

    val feedPost = FeedPost(0)
}
