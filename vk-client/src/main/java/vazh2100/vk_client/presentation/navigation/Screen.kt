package vazh2100.vk_client.presentation.navigation

import android.net.Uri
import com.google.gson.Gson
import vazh2100.vk_client.domain.entities.FeedPost

sealed class Screen(val route: String) {
    data object Home : Screen(route = "home")
    data object Feed : Screen(route = "news_feed")
    data object Comments : Screen(
        route = "comments&{post}"
    ) {
        const val POST_KEY = "post"
        fun route(post: FeedPost): String {
            val postJson = Uri.encode(Gson().toJson(post))
            return "comments&$postJson"
        }
    }

    data object Favourite : Screen(route = "favourite")
    data object Profile : Screen(route = "profile")
}
