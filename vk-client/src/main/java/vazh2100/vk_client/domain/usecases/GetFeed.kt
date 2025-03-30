package vazh2100.vk_client.domain.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import vazh2100.vk_client.data.mappers.NewsFeedMapper.toFeedPosts
import vazh2100.vk_client.data.network.ApiFactory.apiService

object GetFeed {
    suspend operator fun invoke(startFrom: String?) = withContext(Dispatchers.IO) {
        try {
            val token = GetToken()
            val response = apiService.recommendations(token, startFrom)
            val mapped = response.toFeedPosts()
            Result.success(mapped to response.response.nextFrom)
        } catch (e: Exception) {
            Result.failure(Exception("Не удалось получить ленту новостей."))
        }
    }
}
