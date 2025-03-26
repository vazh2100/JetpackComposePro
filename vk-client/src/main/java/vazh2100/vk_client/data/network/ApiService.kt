package vazh2100.vk_client.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import vazh2100.vk_client.data.network.models.comments.CommentsResponseDTO
import vazh2100.vk_client.data.network.models.feed.NewsFeedResponseDTO

interface ApiService {

    @GET("newsfeed.get?v=5.199")
    suspend fun feed(
        @Query("access_token") token: String,
        @Query("start_from") startFrom: String?,
        @Query("filters") filters: List<String> = listOf("post"),
    ): NewsFeedResponseDTO

    @GET("newsfeed.getRecommended?v=5.199")
    suspend fun recommendations(
        @Query("access_token") token: String,
        @Query("start_from") startFrom: String?,
        @Query("filters") filters: List<String> = listOf("post"),
    ): NewsFeedResponseDTO

    @GET("newsfeed.ignoreItem?v=5.199")
    suspend fun ignoreItem(
        @Query("access_token") token: String,
        @Query("owner_id") ownerId: Long,
        @Query("item_id") postId: Long,
        @Query("type") type: String = "wall",
    )

    @GET("wall.getComments?v=5.199")
    suspend fun comments(
        @Query("access_token") token: String,
        @Query("owner_id") ownerId: Long,
        @Query("post_id") postId: Long,
        @Query("extended") extended: Int = 1,
        @Query("fields") fields: String = "photo_100",
    ): CommentsResponseDTO

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
