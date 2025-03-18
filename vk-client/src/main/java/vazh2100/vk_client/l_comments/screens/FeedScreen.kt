package vazh2100.vk_client.l_comments.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import vazh2100.vk_client.j_lazy_column.entities.FeedPost

import vazh2100.vk_client.j_lazy_column.widgets.PostCard
import vazh2100.vk_client.l_comments.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen(
    viewModel: HomeViewModel,
    postStates: List<State<FeedPost>>,
    modifier: Modifier = Modifier,
) {

    viewModel.recomposeList.intValue

    LazyColumn(modifier = modifier) {
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
                    onCommentsPress = { viewModel.onCommentsPress(index) },
                    onLikesPress = { viewModel.onLikesPress(index) },
                )
            }
        }
    }
}
