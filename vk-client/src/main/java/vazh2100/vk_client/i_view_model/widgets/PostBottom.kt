package vazh2100.vk_client.i_view_model.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vazh2100.vk_client.R
import vazh2100.vk_client.d_vk_client.IconWithText
import vazh2100.vk_client.h_click_listeners.entities.FeedPost

@Composable
fun PostBottom(
    feedPost: State<FeedPost>,
    onViewsPress: () -> Unit,
    onSharesPress: () -> Unit,
    onCommentsPress: () -> Unit,
    onLikesPress: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val views by remember { derivedStateOf { feedPost.value.statistics.views } }
    val shares by remember { derivedStateOf { feedPost.value.statistics.shares } }
    val comments by remember { derivedStateOf { feedPost.value.statistics.comments } }
    val likes by remember { derivedStateOf { feedPost.value.statistics.likes } }
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        IconWithText(
            iconResId = R.drawable.ic_views_count,
            text = views.toString(),
            modifier = Modifier.clickable(onClick = onViewsPress),
        )
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            IconWithText(
                iconResId = R.drawable.ic_share,
                text = shares.toString(),
                modifier = Modifier.clickable(onClick = onSharesPress),
            )
            IconWithText(
                iconResId = R.drawable.ic_comment,
                text = comments.toString(),
                modifier = Modifier.clickable(onClick = onCommentsPress),
            )
            IconWithText(
                iconResId = R.drawable.ic_like,
                text = likes.toString(),
                modifier = Modifier.clickable(onClick = onLikesPress),
            )
        }
    }
}
