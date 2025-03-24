package vazh2100.vk_client.entities

data class FeedPost(
    val id: String,
    val communityName: String,
    val publicationDate: String,
    val avatarUrl: String,
    val text: String,
    val image: String?,
    val statistics: PostStatistics,
    val isLiked: Boolean
) {
    val views: Int get() = statistics.views
    val shares: Int get() = statistics.shares
    val comments: Int get() = statistics.comments
    val likes: Int get() = statistics.likes
}
