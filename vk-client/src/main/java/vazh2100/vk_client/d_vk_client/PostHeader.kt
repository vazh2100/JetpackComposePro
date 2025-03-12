package vazh2100.vk_client.d_vk_client

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import vazh2100.vk_client.R

@Composable
fun PostHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Image(
            modifier = Modifier.size(50.dp).clip(CircleShape),
            painter = painterResource(R.drawable.post_comunity_thumbnail),
            contentDescription = null,
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "/dev/null",
                color = MaterialTheme.colorScheme.onPrimary,
            )
            Text(
                text = "14:00",
                color = MaterialTheme.colorScheme.onSecondary,
            )
        }
        Icon(
            imageVector = Icons.Rounded.MoreVert, null,
            tint = MaterialTheme.colorScheme.onSecondary
        )
    }
}