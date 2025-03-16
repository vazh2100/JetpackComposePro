package vazh2100.vk_client.j_lazy_column.entities

import vazh2100.vk_client.R
import vazh2100.vk_client.h_click_listeners.entities.PostStatistics

data class FeedPost(
    val id: Int,
    val communityName: String = "/dev/null",
    val publicationDate: String = "14:00",
    val avatarResId: Int = R.drawable.post_comunity_thumbnail,
    val textResId: Int = R.string.mock_post_text,
    val imageResId: Int = R.drawable.mock_post_content,
    val statistics: PostStatistics = PostStatistics(1000, 10, 12, 345),
) {
    val views: Int get() = statistics.views
    val shares: Int get() = statistics.shares
    val comments: Int get() = statistics.comments
    val likes: Int get() = statistics.likes
}
