package vazh2100.vk_client.presentation.screens.feed.widget

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
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import vazh2100.vk_client.domain.entities.FeedPost

@Composable
fun PostContent(feedPost: State<FeedPost>) {
    val text by remember { derivedStateOf { feedPost.value.text } }
    val image by remember { derivedStateOf { feedPost.value.image } }
    Text(text)
    Spacer(Modifier.height(8.dp))
    AsyncImage(
        model = image,
        null,
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}
