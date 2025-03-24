package vazh2100.vk_client.domain.entities

data class FeedPost(
    val id: Long,
    val communityId: Long,
    val communityName: String,
    val publicationDate: String,
    val avatarUrl: String,
    val text: String,
    val image: String?,
    val statistics: PostStatistics,
) {
    val views: Int get() = statistics.views
    val shares: Int get() = statistics.shares
    val comments: Int get() = statistics.comments
    val likes: Int get() = statistics.likes
}
