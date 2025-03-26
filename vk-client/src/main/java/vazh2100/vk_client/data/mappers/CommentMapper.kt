package vazh2100.vk_client.data.mappers

import vazh2100.vk_client.data.network.models.comments.CommentsResponseDTO
import vazh2100.vk_client.domain.entities.Comment
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.absoluteValue

object CommentMapper {
    fun CommentsResponseDTO.toComments(): List<Comment> {
        val comments = this.response.comments
        val users = this.response.profiles
        return buildList {
            for (comment in comments) {
                val user = users.find { it.id == comment.userId.absoluteValue } ?: break
                val commentToAdd = Comment(
                    id = comment.id,
                    authorName = "${user.firstName} ${user.lastName}",
                    authorAvatar = user.photo,
                    commentText = comment.text,
                    publicationDate = comment.date.formatDate()
                )
                add(commentToAdd)
            }
        }
    }

    private fun Long.formatDate(): String =
        SimpleDateFormat("d MMMM yyyy, hh:mm", Locale.getDefault()).format(Date(this * 1000))
}