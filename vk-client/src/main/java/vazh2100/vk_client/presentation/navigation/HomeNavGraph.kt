package vazh2100.vk_client.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.google.gson.Gson
import vazh2100.vk_client.domain.entities.FeedPost
import vazh2100.vk_client.presentation.navigation.Screen.Comments
import vazh2100.vk_client.presentation.navigation.Screen.Feed
import vazh2100.vk_client.presentation.navigation.Screen.Home

fun NavGraphBuilder.homeNavGraph(
    feed: @Composable () -> Unit,
    comments: @Composable (post: FeedPost) -> Unit,
) {
    navigation(
        route = Home.route,
        startDestination = Feed.route,
    ) {
        composable(route = Feed.route, content = { feed() })
        composable(
            route = Comments.route,
            arguments = listOf(
                navArgument(Comments.POST_KEY) { type = NavType.StringType },
            ),
        ) {
            val postJson = it.arguments?.getString(Comments.POST_KEY) ?: error("Ошибка программиста")
            val post = Gson().fromJson(postJson, FeedPost::class.java)
            comments(post)
        }
    }
}