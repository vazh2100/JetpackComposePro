package vazh2100.vk_client.k_navigation.widgets

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
import androidx.navigation.compose.currentBackStackEntryAsState
import vazh2100.vk_client.k_navigation.navigation.BottomNavigationItem

@Composable
fun BottomBar(
    navController: NavController,
    modifier: Modifier = Modifier,
) = NavigationBar(modifier = modifier) {
    val backStack by navController.currentBackStackEntryAsState()
    val current = backStack?.destination?.route
    BottomNavigationItem.entries.forEach { item ->
        NavigationBarItem(
            selected = item.screen.route == current,
            onClick = {
                if (item.screen.route != current) {
                    navController.navigate(item.screen.route) {
                        popUpTo(BottomNavigationItem.HOME.screen.route) { saveState = true }
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
