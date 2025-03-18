package vazh2100.vk_client

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import vazh2100.vk_client.l_comments.HomeViewModel
import vazh2100.vk_client.l_comments.MainScreen
import vazh2100.vk_client.theme.VkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[HomeViewModel::class]
        setContent {
            VkTheme {
                Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(8.dp)) {
                    MainScreen(viewModel)
                }
            }
        }
    }
}
