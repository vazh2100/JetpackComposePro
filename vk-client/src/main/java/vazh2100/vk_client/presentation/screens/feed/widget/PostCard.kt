package vazh2100.vk_client.presentation.screens.feed.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import vazh2100.vk_client.domain.entities.FeedPost


@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    feedPost: State<FeedPost>,
    onCommentsPress: () -> Unit,
    onLikesPress: () -> Unit,
) {

    Card {
        Column(modifier = modifier.padding(16.dp)) {
            PostHeader(feedPost)
            Spacer(Modifier.height(8.dp))
            PostContent(feedPost)
            Spacer(Modifier.height(8.dp))
            PostBottom(
                feedPost = feedPost,
                onCommentsPress = onCommentsPress,
                onLikesPress = onLikesPress,
            )
        }
    }
}
