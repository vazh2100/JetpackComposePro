package vazh2100.vk_client.l_comments.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import vazh2100.vk_client.l_comments.navigation.Screen.Favourite
import vazh2100.vk_client.l_comments.navigation.Screen.Home
import vazh2100.vk_client.l_comments.navigation.Screen.Profile

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    feed: @Composable () -> Unit,
    comments: @Composable (id: Int) -> Unit,
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
