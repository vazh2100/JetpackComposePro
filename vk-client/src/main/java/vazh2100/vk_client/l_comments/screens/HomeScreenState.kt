package vazh2100.vk_client.l_comments.screens

import androidx.compose.runtime.State
import vazh2100.vk_client.j_lazy_column.entities.FeedPost
import vazh2100.vk_client.l_comments.entities.Comment

sealed class HomeScreenState {
    data class Posts(val feedPosts: List<State<FeedPost>>) : HomeScreenState()
    data class Comments(val feedPost: FeedPost, val comments: List<Comment>) : HomeScreenState()
}
