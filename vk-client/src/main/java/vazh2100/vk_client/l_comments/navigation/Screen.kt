package vazh2100.vk_client.l_comments.navigation

sealed class Screen(val route: String) {
    data object Feed : Screen(route = "news_feed")
    data object Comments : Screen(route = "comments")
    data object Favourite : Screen(route = "favourite")
    data object Profile : Screen(route = "profile")
}
