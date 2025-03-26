package vazh2100.vk_client.presentation.screens.comments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import vazh2100.vk_client.domain.entities.Comment
import vazh2100.vk_client.domain.entities.FeedPost
import vazh2100.vk_client.domain.usecases.GetComments

class CommentsViewModel(private val post: FeedPost) : ViewModel() {
    private val _comments = MutableStateFlow<List<Comment>>(emptyList())
    val comments = _comments.asStateFlow()

    init {
        viewModelScope.launch { _comments.value = GetComments(post) }
    }

    @Suppress("UNCHECKED_CAST")
    class Factory(private val post: FeedPost) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CommentsViewModel(post) as T
        }
    }
}
