package vazh2100.vk_client.l_comments.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navController: NavHostController,
    feed: @Composable () -> Unit,
    comments: @Composable () -> Unit,
    favourite: @Composable () -> Unit,
    profile: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Feed.route
    ) {
        composable(route = Screen.Feed.route, content = { feed() })
        composable(route = Screen.Comments.route, content = { comments() })
        composable(route = Screen.Favourite.route, content = { favourite() })
        composable(route = Screen.Profile.route, content = { profile() })
    }
}
