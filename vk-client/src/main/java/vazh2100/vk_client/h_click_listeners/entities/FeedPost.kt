package vazh2100.vk_client.h_click_listeners.entities

import vazh2100.vk_client.R

data class FeedPost(
    val communityName: String = "/dev/null",
    val publicationDate: String = "14:00",
    val avatarResId: Int = R.drawable.post_comunity_thumbnail,
    val textResId: Int = R.string.mock_post_text,
    val imageResId: Int = R.drawable.mock_post_content,
    val statistics: PostStatistics = PostStatistics(1000, 10, 12, 345),
)
