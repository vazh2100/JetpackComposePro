package vazh2100.vk_client.l_comments.navigation

sealed class Screen(val route: String) {
    data object Home : Screen(route = "home")
    data object Feed : Screen(route = "news_feed")
    data object Comments : Screen(route = "comments&{post_id}") {
        const val POST_ID_KEY = "post_id"
        fun route(id: Int) = "comments&$id"
    }

    data object Favourite : Screen(route = "favourite")
    data object Profile : Screen(route = "profile")
}
