package vazh2100.vk_client.d_vk_client

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vazh2100.vk_client.R

@Preview
@Composable
fun PostCard(modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(16.dp)) {
        Column {
            PostHeader()
            Spacer(Modifier.height(8.dp))
            Text(stringResource(R.string.mock_post_text))
            Spacer(Modifier.height(8.dp))
            Image(
                painterResource(R.drawable.mock_post_content),
                null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth,
            )
            Spacer(Modifier.height(8.dp))
            PostBottom()
        }
    }
}






