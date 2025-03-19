package vazh2100.vk_client.l_comments.navigation

import android.net.Uri
import com.google.gson.Gson
import vazh2100.vk_client.j_lazy_column.entities.FeedPost

sealed class Screen(val route: String) {
    data object Home : Screen(route = "home")
    data object Feed : Screen(route = "news_feed")
    data object Comments : Screen(
        route = "comments&{post_id}&{feed_post}"
    ) {
        const val POST_ID_KEY = "post_id"
        const val FEED_POST_KEY = "feed_post"
        fun route(id: Int, feedPost: FeedPost): String {
            val post = Uri.encode(Gson().toJson(feedPost))
            return "comments&$id&$post"
        }
    }

    data object Favourite : Screen(route = "favourite")
    data object Profile : Screen(route = "profile")
}
