package vazh2100.vk_client.domain.entities

import vazh2100.vk_client.R

data class Comment(
    val id: Int,
    val authorName: String = "Author Name $id",
    val authorAvatarId: Int = R.drawable.comment_author_avatar,
    val commentText: String = "Замечательное видео. Лол.",
    val publicationDate: String = "14:00",
)
