package vazh2100.vk_client.l_comments

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import vazh2100.vk_client.k_navigation.navigation.AppNavGraph
import vazh2100.vk_client.k_navigation.widgets.BottomBar
import vazh2100.vk_client.l_comments.screens.CommentScreen
import vazh2100.vk_client.l_comments.screens.FeedScreen
import vazh2100.vk_client.l_comments.screens.HomeScreenState

@Composable
fun MainScreen(
    viewModel: HomeViewModel,
    modifier: Modifier = Modifier,
) {

    val navController = rememberNavController()

    Scaffold(
        modifier = modifier,
        bottomBar = { BottomBar(navController) },
        content = { paddingValues ->
            AppNavGraph(
                modifier = Modifier.padding(paddingValues),
                navController = navController,
                feed = {
                    val screenState by viewModel.screenState.collectAsState()
                    when (val state = screenState) {
                        is HomeScreenState.Comments -> CommentScreen(
                            feedPost = state.feedPost,
                            comments = state.comments,
                        )
                        is HomeScreenState.Posts -> FeedScreen(viewModel, state.feedPosts)
                    }

                },
                favourite = {
                    var count by rememberSaveable { mutableIntStateOf(0) }
                    Text("favourite $count", modifier = Modifier.clickable { count++ })
                },
                profile = { Text("profile") }
            )

        },
    )
}
