package vazh2100.vk_client.j_lazy_column

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import vazh2100.vk_client.j_lazy_column.widgets.BottomBar
import vazh2100.vk_client.j_lazy_column.widgets.PostCard

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {

    Scaffold(
        modifier = modifier,
        bottomBar = { BottomBar() },
        content = { paddingValues ->
            val postStates = viewModel.feedPosts
            viewModel.recomposeList.intValue
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                itemsIndexed(postStates, key = { _, item -> item.value.id }) { index, it ->
                    val state = rememberSwipeToDismissBoxState()
                    if (state.currentValue == SwipeToDismissBoxValue.EndToStart) viewModel.onSwipe(index)
                    SwipeToDismissBox(
                        modifier = Modifier.animateItemPlacement(),
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
        },
    )
}
