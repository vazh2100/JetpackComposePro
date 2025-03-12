package vazh2100.vk_client.d_vk_client

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vazh2100.vk_client.R

@Composable
fun PostBottom(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        IconWithText(R.drawable.ic_views_count, "909")
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            IconWithText(R.drawable.ic_share, "1000")
            IconWithText(R.drawable.ic_comment, "2")
            IconWithText(R.drawable.ic_like, "10")
        }
    }
}