package vazh2100.vk_client.g_state

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import vazh2100.vk_client.R

enum class BottomNavigationItem(val title: Int, val icon: ImageVector) {
    HOME(title = R.string.nav_item_home, icon = Icons.Filled.Home),
    FAVOURITE(title = R.string.nav_item_favourite, icon = Icons.Filled.Favorite),
    PROFILE(title = R.string.nav_item_profile, icon = Icons.Filled.Person),
}
