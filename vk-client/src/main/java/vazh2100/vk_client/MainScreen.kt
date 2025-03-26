package vazh2100.vk_client

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

import vazh2100.vk_client.presentation.navigation.BottomBar
import vazh2100.vk_client.presentation.navigation.BottomNavGraph
import vazh2100.vk_client.presentation.navigation.Screen
import vazh2100.vk_client.presentation.screens.comments.CommentScreen
import vazh2100.vk_client.presentation.screens.feed.FeedScreen

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {

    val navController = rememberNavController()

    Scaffold(
        modifier = modifier,
        bottomBar = { BottomBar(navController) },
        content = { paddingValues ->
            BottomNavGraph(
                modifier = Modifier.padding(paddingValues),
                navController = navController,
                feed = {
                    FeedScreen(
                        onCommentsPress = {
                            navController.navigate(Screen.Comments.route(it))
                        },
                    )
                },
                comments = { post -> CommentScreen(onBackPress = { navController.popBackStack() }, post = post) },
                favourite = {
                    var count by rememberSaveable { mutableIntStateOf(0) }
                    Text("favourite $count", modifier = Modifier.clickable { count++ })
                },
                profile = { Text("profile") }
            )
        },
    )
}
