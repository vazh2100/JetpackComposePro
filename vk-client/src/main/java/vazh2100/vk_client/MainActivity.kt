package vazh2100.vk_client

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import vazh2100.vk_client.m_activity_for_result.ActivityForResult

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActivityForResult()
//            VkTheme {
//                Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(8.dp)) {
//
//                }
//            }
        }
    }
}
