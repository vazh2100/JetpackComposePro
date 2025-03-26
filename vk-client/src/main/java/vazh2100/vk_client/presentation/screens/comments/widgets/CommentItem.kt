package vazh2100.vk_client.presentation.screens.comments.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import vazh2100.vk_client.domain.entities.Comment

@Composable
fun CommentItem(
    comment: Comment,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
        content = {
            AsyncImage(
                model = comment.authorAvatar,
                modifier = Modifier.size(48.dp).clip(CircleShape),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = comment.authorName,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 12.sp,
                )
                Text(
                    text = comment.commentText,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 14.sp,
                )
                Text(
                    text = comment.publicationDate,
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontSize = 12.sp,
                )
            }
        },
    )
}
