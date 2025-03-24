package vazh2100.vk_client.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import vazh2100.vk_client.data.network.models.NewsFeedResponseDTO

interface ApiService {

    @GET("newsfeed.getRecommended?v=5.199")
    suspend fun feed(@Query("access_token") token: String): NewsFeedResponseDTO
}
