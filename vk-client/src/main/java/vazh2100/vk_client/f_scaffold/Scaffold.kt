package vazh2100.vk_client.f_scaffold

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold(modifier: Modifier = Modifier) = Scaffold(
    topBar = {
        TopAppBar(
            title = { Text("TopAppBar") },
            navigationIcon = {
                IconButton(
                    onClick = {},
                    content = {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Icon",
                        )
                    },
                )
            },
        )
    },
    content = { Text(text = "Scaffold Content", modifier = modifier.padding(it)) },
    bottomBar = {
        val items = listOf("First", "Second", "Third")
        NavigationBar {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = { Icon(imageVector = Icons.Filled.Favorite, contentDescription = null) },
                    label = { Text(item) },
                )
            }
        }
    },
)


