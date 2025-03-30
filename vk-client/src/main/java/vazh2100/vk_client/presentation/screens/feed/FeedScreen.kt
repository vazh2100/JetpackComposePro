package vazh2100.vk_client.presentation.screens.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import vazh2100.vk_client.domain.entities.FeedPost
import vazh2100.vk_client.presentation.screens.feed.widget.PostCard
import vazh2100.vk_client.presentation.theme.darkBlue

@Composable
fun FeedScreen(
    onCommentsPress: (post: FeedPost) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: FeedViewModel = viewModel(),
) {
    val scope = rememberCoroutineScope()

    val postStates = viewModel.feedPosts
    viewModel.listRecomposeNeeded.intValue

    val nextLoading = viewModel.nextLoading.collectAsState()
    val nextError = viewModel.nextError.collectAsState()


    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
    ) {
        itemsIndexed(postStates, key = { _, item -> item.value.id + item.value.communityId }) { index, it ->
            val state = rememberSwipeToDismissBoxState()

            SwipeToDismissBox(
                modifier = Modifier.animateItem(),
                state = state,
                backgroundContent = {},
                enableDismissFromStartToEnd = false,
            ) {
                PostCard(
                    feedPost = it,
                    onCommentsPress = { onCommentsPress(it.value) },
                    onLikesPress = { viewModel.onLikesPress(index) },
                )
            }
            LaunchedEffect(state.currentValue) {
                if (state.currentValue == SwipeToDismissBoxValue.EndToStart) {
                    viewModel.onSwipe(index).join()
                    state.reset()
                }
            }
        }
        item {
            if (nextError.value) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text("При загрузке произошла ошибка")
                    Button(viewModel::onFeedEndReached) { Text("Повторить") }
                }
            } else if (nextLoading.value) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator(color = darkBlue)
                }
            } else {
                SideEffect(viewModel::onFeedEndReached)
            }
        }
    }
}
