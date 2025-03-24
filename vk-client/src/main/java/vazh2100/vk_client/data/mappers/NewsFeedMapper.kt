package vazh2100.vk_client.data.mappers

import vazh2100.vk_client.data.network.models.NewsFeedResponseDTO
import vazh2100.vk_client.domain.entities.FeedPost
import vazh2100.vk_client.domain.entities.PostStatistics
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.absoluteValue

object NewsFeedMapper {

    fun NewsFeedResponseDTO.toFeedPosts(): List<FeedPost> {
        val posts = this.response.posts
        val groups = this.response.groups
        return buildList {
            for (post in posts) {
                val group = groups.find { it.id == post.groupId.absoluteValue } ?: break
                val feedPost = FeedPost(
                    id = post.id,
                    communityId = post.groupId,
                    communityName = group.name,
                    publicationDate = post.date.formatDate(),
                    avatarUrl = group.photo,
                    text = post.text ?: "",
                    image = post.attachments?.firstOrNull()?.photo?.urls?.lastOrNull()?.url,
                    statistics = PostStatistics(
                        views = post.views?.count ?: 0,
                        shares = post.shares?.count ?: 0,
                        comments = post.comments?.count ?: 0,
                        likes = post.likes?.count ?: 0,
                        isLiked = (post.likes?.isLiked ?: 0) == 1,
                    ),
                )
                add(feedPost)
            }
        }
    }

    private fun Long.formatDate(): String = SimpleDateFormat("d MMMM yyyy, hh:mm", Locale.getDefault())
        .format(Date(this * 1000))
}
