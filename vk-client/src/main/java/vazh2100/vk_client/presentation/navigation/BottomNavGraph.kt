package vazh2100.vk_client.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import vazh2100.vk_client.domain.entities.FeedPost
import vazh2100.vk_client.presentation.navigation.Screen.Favourite
import vazh2100.vk_client.presentation.navigation.Screen.Home
import vazh2100.vk_client.presentation.navigation.Screen.Profile

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    feed: @Composable () -> Unit,
    comments: @Composable (post: FeedPost) -> Unit,
    favourite: @Composable () -> Unit,
    profile: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Home.route
    ) {
        homeNavGraph(feed = feed, comments = comments)
        composable(route = Favourite.route, content = { favourite() })
        composable(route = Profile.route, content = { profile() })
    }
}
