package vazh2100.vk_client.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import vazh2100.vk_client.R

enum class BottomNavigationItem(
    val title: Int,
    val icon: ImageVector,
    val screen: Screen,
) {
    HOME(
        title = R.string.nav_item_home,
        icon = Icons.Filled.Home,
        screen = Screen.Home
    ),
    FAVOURITE(
        title = R.string.nav_item_favourite,
        icon = Icons.Filled.Favorite,
        screen = Screen.Favourite
    ),
    PROFILE(
        title = R.string.nav_item_profile,
        icon = Icons.Filled.Person,
        screen = Screen.Profile
    ),
}
