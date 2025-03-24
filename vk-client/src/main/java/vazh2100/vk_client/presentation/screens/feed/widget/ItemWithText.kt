package vazh2100.vk_client.presentation.screens.feed.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun IconWithText(
    iconResId: Int,
    text: String,
    modifier: Modifier = Modifier,
    tintColor: Color = MaterialTheme.colorScheme.onSecondary,
) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(iconResId),
            contentDescription = null,
            tint = tintColor
        )
        Spacer(Modifier.width(4.dp))
        Text(text, color = MaterialTheme.colorScheme.onSecondary)
    }
}