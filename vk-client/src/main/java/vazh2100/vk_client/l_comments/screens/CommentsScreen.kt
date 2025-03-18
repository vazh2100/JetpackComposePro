package vazh2100.vk_client.l_comments.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import vazh2100.vk_client.j_lazy_column.entities.FeedPost
import vazh2100.vk_client.l_comments.entities.Comment
import vazh2100.vk_client.l_comments.widgets.CommentItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentScreen(
    feedPost: FeedPost,
    comments: List<Comment>,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {},
                        content = {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null,
                            )
                        },
                    )
                },
                title = { Text("Comments for ${feedPost.id}") },
            )
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier.padding(padding),
                content = {
                    items(
                        items = comments,
                        key = { it.id },
                        itemContent = { CommentItem(it) },
                    )
                },
            )
        },
    )
}

