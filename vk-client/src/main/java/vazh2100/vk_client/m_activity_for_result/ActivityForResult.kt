package vazh2100.vk_client.m_activity_for_result

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vk.id.AccessToken
import com.vk.id.VKID
import com.vk.id.VKIDAuthFail
import com.vk.id.auth.VKIDAuthCallback
import kotlinx.coroutines.launch

@Composable
fun ActivityForResult(modifier: Modifier = Modifier) {

    var result by remember { mutableStateOf<String?>(null) }

    val callback = remember {
        object : VKIDAuthCallback {
            override fun onAuth(accessToken: AccessToken) {
                result = accessToken.userData.firstName
            }

            override fun onFail(fail: VKIDAuthFail) = println(fail)
        }
    }

    val scope = rememberCoroutineScope()

    Column(modifier = modifier.fillMaxSize().padding(8.dp)) {
        Text(result.toString())
        TextButton(
            onClick = { scope.launch { VKID.instance.authorize(callback = callback) } },
            content = { Text("Button") },
        )
    }
}
