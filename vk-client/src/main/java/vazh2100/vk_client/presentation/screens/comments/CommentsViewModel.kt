package vazh2100.vk_client.presentation.screens.comments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import vazh2100.vk_client.entities.Comment

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
