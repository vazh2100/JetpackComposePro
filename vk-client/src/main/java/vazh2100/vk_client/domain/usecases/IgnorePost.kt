package vazh2100.vk_client.domain.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import vazh2100.vk_client.data.network.ApiFactory.apiService
import vazh2100.vk_client.domain.entities.FeedPost

object IgnorePost {
    suspend operator fun invoke(post: FeedPost) = withContext(Dispatchers.IO) {
        try {
            apiService.ignoreItem(token = GetToken(), ownerId = post.communityId, postId = post.id)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
