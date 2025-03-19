package vazh2100.vk_client.l_comments.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import vazh2100.vk_client.l_comments.navigation.Screen.Comments
import vazh2100.vk_client.l_comments.navigation.Screen.Feed
import vazh2100.vk_client.l_comments.navigation.Screen.Home

fun NavGraphBuilder.homeNavGraph(
    feed: @Composable () -> Unit,
    comments: @Composable (postId: Int) -> Unit,
) {
    navigation(
        route = Home.route,
        startDestination = Feed.route,
    ) {
        composable(route = Feed.route, content = { feed() })
        composable(
            route = Comments.route,
            arguments = listOf(navArgument(Comments.POST_ID_KEY) { type = NavType.IntType }),
        ) {
            val id = it.arguments?.getInt(Comments.POST_ID_KEY) ?: error("Ошибка программиста")
            comments(id)
        }
    }
}