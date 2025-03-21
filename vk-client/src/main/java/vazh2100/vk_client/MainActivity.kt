package vazh2100.vk_client

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.vk.id.VKID
import vazh2100.vk_client.n_login.screens.LoginScreen
import vazh2100.vk_client.theme.VkTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            VkTheme {
                val init = rememberSaveable { VKID.init(this@MainActivity); "" }
                Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
                    LoginScreen()
                }

            }
        }
    }
}
