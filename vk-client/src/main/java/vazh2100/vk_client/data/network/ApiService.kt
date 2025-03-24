package vazh2100.vk_client.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import vazh2100.vk_client.data.network.models.NewsFeedResponseDTO

interface ApiService {

    @GET("newsfeed.get?v=5.199")
    suspend fun feed(
        @Query("access_token") token: String,
        @Query("start_from") startFrom: String?,
        @Query("filters") filters: List<String> = listOf("post"),
    ): NewsFeedResponseDTO

    @GET("likes.add?v=5.199")
    suspend fun like(
        @Query("access_token") token: String,
        @Query("owner_id") ownerId: Long,
        @Query("item_id") postId: Long,
        @Query("type") type: String = "post",
    )

    @GET("likes.delete?v=5.199")
    suspend fun unlike(
        @Query("access_token") token: String,
        @Query("owner_id") ownerId: Long,
        @Query("item_id") postId: Long,
        @Query("type") type: String = "post",
    )
}
