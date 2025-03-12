package vazh2100.vk_client.h_click_listeners.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vazh2100.vk_client.R
import vazh2100.vk_client.d_vk_client.IconWithText
import vazh2100.vk_client.h_click_listeners.entities.PostStatistics

@Composable
fun PostBottom(
    state: MutableState<PostStatistics>,
    modifier: Modifier = Modifier,
) {
    var data by state
    val (views, shares, comments, likes) = data
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        IconWithText(
            iconResId = R.drawable.ic_views_count,
            text = views.toString(),
            modifier = Modifier.clickable { data = data.copy(views = views + 1) },
        )
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            IconWithText(
                iconResId = R.drawable.ic_share,
                text = shares.toString(),
                modifier = Modifier.clickable { data = data.copy(shares = shares + 1) },
            )
            IconWithText(
                iconResId = R.drawable.ic_comment,
                text = comments.toString(),
                modifier = Modifier.clickable { data = data.copy(comments = comments + 1) },
            )
            IconWithText(
                iconResId = R.drawable.ic_like,
                text = likes.toString(),
                modifier = Modifier.clickable { data = data.copy(likes = likes + 1) },
            )
        }
    }
}