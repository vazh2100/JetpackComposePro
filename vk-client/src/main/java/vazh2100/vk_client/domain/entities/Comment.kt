package vazh2100.vk_client.domain.entities

data class Comment(
    val id: Int,
    val authorName: String,
    val authorAvatar: String,
    val commentText: String,
    val publicationDate: String,
)
