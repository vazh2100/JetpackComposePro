package vazh2100.vk_client.l_comments.screens.comments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import vazh2100.vk_client.l_comments.entities.Comment

class CommentsViewModel(val postId: Int) : ViewModel() {
    private val _comments = MutableStateFlow(buildList { repeat(10) { add(Comment(it)) } })
    val comments = _comments.asStateFlow()

    @Suppress("UNCHECKED_CAST")
    class Factory(private val postId: Int) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CommentsViewModel(postId) as T
        }
    }
}
