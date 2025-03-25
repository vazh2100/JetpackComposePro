package vazh2100.vk_client.domain.usecases

import vazh2100.vk_client.data.network.ApiFactory.apiService
import vazh2100.vk_client.domain.entities.FeedPost

object IgnorePost {
    suspend operator fun invoke(post: FeedPost) {
        apiService.ignoreItem(token = GetToken(), ownerId = post.communityId, postId = post.id)
    }
}
