package vazh2100.vk_client.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import vazh2100.vk_client.presentation.navigation.Screen.Comments
import vazh2100.vk_client.presentation.navigation.Screen.Feed
import vazh2100.vk_client.presentation.navigation.Screen.Home

fun NavGraphBuilder.homeNavGraph(
    feed: @Composable () -> Unit,
    comments: @Composable (postId: Long) -> Unit,
) {
    navigation(
        route = Home.route,
        startDestination = Feed.route,
    ) {
        composable(route = Feed.route, content = { feed() })
        composable(
            route = Comments.route,
            arguments = listOf(
                navArgument(Comments.POST_ID_KEY) { type = NavType.LongType },
            ),
        ) {
            val id = it.arguments?.getLong(Comments.POST_ID_KEY) ?: error("Ошибка программиста")
            comments(id)
        }
    }
}