package vazh2100.vk_client.h_click_listeners

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import vazh2100.vk_client.g_state.BottomNavigationItem
import vazh2100.vk_client.h_click_listeners.entities.FeedPost
import vazh2100.vk_client.h_click_listeners.widgets.PostCard

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val feedPost by remember { mutableStateOf(FeedPost()) }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            NavigationBar {
                var selectedItem by remember { mutableStateOf(BottomNavigationItem.HOME) }

                BottomNavigationItem.entries.forEach { item ->
                    NavigationBarItem(
                        selected = item == selectedItem,
                        onClick = { selectedItem = item },
                        icon = { Icon(item.icon, null) },
                        label = { Text(stringResource(item.title)) },
                        colors = NavigationBarItemDefaults.colors(
                            unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                            unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                        )
                    )
                }
            }
        },
        content = { paddingValues ->
            PostCard(
                modifier = Modifier.padding(paddingValues),
                feedPost = feedPost,
            )
        },
    )
}
