package vazh2100.vk_client.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import vazh2100.vk_client.presentation.navigation.Screen.Feed

@Composable
fun BottomBar(
    navController: NavController,
    modifier: Modifier = Modifier,
) = NavigationBar(modifier = modifier) {
    val backStack by navController.currentBackStackEntryAsState()
    BottomNavigationItem.entries.forEach { item ->
        val selected = backStack?.destination?.hierarchy?.any { it.route == item.screen.route } ?: false
        NavigationBarItem(
            selected = selected,
            onClick = {
                if (!selected) {
                    navController.navigate(item.screen.route) {
                        popUpTo(Feed.route) { saveState = true }
                        restoreState = true
                    }
                }
            },
            icon = { Icon(item.icon, null) },
            label = { Text(stringResource(item.title)) },
            colors = NavigationBarItemDefaults.colors(
                unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
            )
        )
    }
}
