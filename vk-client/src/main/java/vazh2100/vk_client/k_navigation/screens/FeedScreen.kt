package vazh2100.vk_client.k_navigation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import vazh2100.vk_client.j_lazy_column.MainViewModel
import vazh2100.vk_client.j_lazy_column.widgets.PostCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {

    val postStates = viewModel.feedPosts
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
