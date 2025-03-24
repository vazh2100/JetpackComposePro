package vazh2100.vk_client.presentation.screens.comments

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import vazh2100.vk_client.presentation.screens.comments.widgets.CommentItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentScreen(
    onBackPress: () -> Unit,
    postId: Int,
    viewModel: CommentsViewModel = viewModel(factory = CommentsViewModel.Factory(postId)),
    modifier: Modifier = Modifier,
) {

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = onBackPress,
                        content = {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null,
                            )
                        },
                    )
                },
                title = { Text("Comments for ${viewModel.postId}") },
            )
        },
        content = { padding ->
            val comments by viewModel.comments.collectAsState()

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

