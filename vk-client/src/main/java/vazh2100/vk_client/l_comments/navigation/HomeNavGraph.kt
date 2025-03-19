package vazh2100.vk_client.l_comments.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import vazh2100.vk_client.l_comments.navigation.Screen.Comments
import vazh2100.vk_client.l_comments.navigation.Screen.Feed
import vazh2100.vk_client.l_comments.navigation.Screen.Home

fun NavGraphBuilder.homeNavGraph(
    feed: @Composable () -> Unit,
    comments: @Composable () -> Unit,
) {
    navigation(
        route = Home.route,
        startDestination = Feed.route,
    ) {
        composable(route = Feed.route, content = { feed() })
        composable(route = Comments.route, content = { comments() })
    }
}