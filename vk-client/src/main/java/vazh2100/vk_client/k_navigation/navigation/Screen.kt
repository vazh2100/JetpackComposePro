package vazh2100.vk_client.k_navigation.navigation

sealed class Screen(val route: String) {
    data object Feed : Screen(route = "news_feed")
    data object Favourite : Screen(route = "favourite")
    data object Profile : Screen(route = "profile")
}
