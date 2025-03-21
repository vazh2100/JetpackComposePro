package vazh2100.vk_client.l_comments.screens.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import vazh2100.vk_client.j_lazy_column.widgets.PostCard

@Composable
fun FeedScreen(
    onCommentsPress: (postId: Int) -> Unit,
    viewModel: FeedViewModel = viewModel(),
    modifier: Modifier = Modifier,
) {
    val postStates = viewModel.feedPosts
    viewModel.recomposeList.intValue

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
    ) {
        itemsIndexed(postStates, key = { _, item -> item.value.id }) { index, it ->
            val state = rememberSwipeToDismissBoxState()
            if (state.currentValue == SwipeToDismissBoxValue.EndToStart) viewModel.onSwipe(index)
            SwipeToDismissBox(
                modifier = Modifier.animateItem(),
                state = state,
                backgroundContent = {},
                enableDismissFromStartToEnd = false,
            ) {
                PostCard(
                    feedPost = it,
                    onViewsPress = { viewModel.onViewsPress(index) },
                    onSharesPress = { viewModel.onSharesPress(index) },
                    onCommentsPress = { onCommentsPress(it.value.id) },
                    onLikesPress = { viewModel.onLikesPress(index) },
                )
            }
        }
    }
}
