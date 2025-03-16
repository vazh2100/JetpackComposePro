package vazh2100.vk_client.j_lazy_column.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import vazh2100.vk_client.j_lazy_column.entities.FeedPost

@Composable
fun PostContent(feedPost: State<FeedPost>) {
    val id by remember { derivedStateOf { feedPost.value.id } }
    val textResId by remember { derivedStateOf { feedPost.value.textResId } }
    val imageResId by remember { derivedStateOf { feedPost.value.imageResId } }
    Text(id.toString())
    Text(stringResource(textResId))
    Spacer(Modifier.height(8.dp))
    Image(
        painterResource(imageResId),
        null,
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth,
    )
}
