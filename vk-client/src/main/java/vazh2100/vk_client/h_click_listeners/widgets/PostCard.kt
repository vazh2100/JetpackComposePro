package vazh2100.vk_client.h_click_listeners.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import vazh2100.vk_client.h_click_listeners.entities.FeedPost

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    feedPost: FeedPost,
) {

    val statistics = remember { mutableStateOf(feedPost.statistics) }

    Card(modifier = modifier.padding(16.dp)) {

        Column {
            PostHeader(feedPost)
            Spacer(Modifier.height(8.dp))
            Text(stringResource(feedPost.textResId))
            Spacer(Modifier.height(8.dp))
            Image(
                painterResource(feedPost.imageResId),
                null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth,
            )
            Spacer(Modifier.height(8.dp))
            PostBottom(state = statistics)
        }
    }
}
