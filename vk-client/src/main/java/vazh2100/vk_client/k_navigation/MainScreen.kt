package vazh2100.vk_client.k_navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import vazh2100.vk_client.j_lazy_column.MainViewModel
import vazh2100.vk_client.k_navigation.navigation.AppNavGraph
import vazh2100.vk_client.k_navigation.screens.FeedScreen
import vazh2100.vk_client.k_navigation.widgets.BottomBar

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {

    val navController = rememberNavController()

    Scaffold(
        modifier = modifier,
        bottomBar = { BottomBar(navController) },
        content = { paddingValues ->
            AppNavGraph(
                modifier = Modifier.padding(paddingValues),
                navController = navController,
                feed = { FeedScreen(viewModel) },
                favourite = {
                    var count by rememberSaveable { mutableIntStateOf(0) }
                    Text("favourite $count", modifier = Modifier.clickable { count++ })
                },
                profile = { Text("profile") }
            )

        },
    )
}
