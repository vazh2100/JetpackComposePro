package vazh2100.vk_client.domain.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import vazh2100.vk_client.data.mappers.CommentMapper.toComments
import vazh2100.vk_client.data.network.ApiFactory.apiService
import vazh2100.vk_client.domain.entities.FeedPost

object GetComments {
    suspend operator fun invoke(post: FeedPost) = withContext(Dispatchers.IO) {
        val response = apiService.comments(token = GetToken(), ownerId = post.communityId, postId = post.id)
        response.toComments()
    }
}