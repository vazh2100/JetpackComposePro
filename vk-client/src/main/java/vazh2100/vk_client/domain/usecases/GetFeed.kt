package vazh2100.vk_client.domain.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import vazh2100.vk_client.data.mappers.NewsFeedMapper.toFeedPosts
import vazh2100.vk_client.data.network.ApiFactory.apiService
import vazh2100.vk_client.domain.entities.FeedPost

object GetFeed {
    suspend operator fun invoke(startFrom: String?): Pair<List<FeedPost>, String> = withContext(Dispatchers.IO) {
        val token = GetToken()
        val response = apiService.feed(token, startFrom)
        response.toFeedPosts() to response.response.nextFrom
    }
}