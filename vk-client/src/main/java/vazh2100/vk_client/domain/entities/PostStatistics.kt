package vazh2100.vk_client.domain.entities

data class PostStatistics(
    val views: Int,
    val shares: Int,
    val comments: Int,
    val likes: Int,
    val isLiked: Boolean,
)
