package vazh2100.vk_client.presentation.screens.feed.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vazh2100.vk_client.R
import vazh2100.vk_client.domain.entities.FeedPost
import vazh2100.vk_client.presentation.theme.darkRed

@Composable
fun PostBottom(
    feedPost: State<FeedPost>,
    onCommentsPress: () -> Unit,
    onLikesPress: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val views by remember { derivedStateOf { feedPost.value.statistics.views } }
    val shares by remember { derivedStateOf { feedPost.value.statistics.shares } }
    val comments by remember { derivedStateOf { feedPost.value.statistics.comments } }
    val likes by remember { derivedStateOf { feedPost.value.statistics.likes } }
    val liked by remember { derivedStateOf { feedPost.value.statistics.isLiked } }
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        IconWithText(
            iconResId = R.drawable.ic_views_count,
            text = formatStatistic(views),
            modifier = Modifier,
        )
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            IconWithText(
                iconResId = R.drawable.ic_share,
                text = formatStatistic(shares),
                modifier = Modifier,
            )
            IconWithText(
                iconResId = R.drawable.ic_comment,
                text = formatStatistic(comments),
                modifier = Modifier.clickable(onClick = onCommentsPress),
            )
            IconWithText(
                iconResId = if (liked) R.drawable.ic_like_set else R.drawable.ic_like,
                tintColor = if (liked) darkRed else MaterialTheme.colorScheme.onSecondary,
                text = formatStatistic(likes),
                modifier = Modifier.clickable(onClick = onLikesPress),
            )
        }
    }
}

fun formatStatistic(count: Int): String {
    return if (count > 100_000) String.format("%sK", count / 1000)
    else if (count > 1000) String.format("%.1fK", count / 1000f)
    else count.toString()
}
