package vazh2100.vk_client.m_activity_for_result

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun ActivityForResult(modifier: Modifier = Modifier) {

    var imageUri by remember { mutableStateOf(Uri.EMPTY) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { imageUri = it },
    )

    Column(modifier = modifier.fillMaxSize().padding(8.dp)) {
        AsyncImage(imageUri, null)
        TextButton(
            onClick = { launcher.launch("image/*") },
            content = { Text("Button") },
        )
    }
}