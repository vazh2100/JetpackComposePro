package com.vazh2100.jetpackcompose.d_vk_client

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vazh2100.jetpackcompose.R

@Preview
@Composable
fun Post(modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Image(
                modifier = Modifier.size(50.dp).clip(CircleShape),
                painter = painterResource(R.drawable.post_comunity_thumbnail),
                contentDescription = null,
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "/dev/null",
                    color = MaterialTheme.colorScheme.onPrimary,
                )
                Text(
                    text = "14:00",
                    color = MaterialTheme.colorScheme.onSecondary,
                )
            }
            Icon(
                imageVector = Icons.Rounded.MoreVert, null,
                tint = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}