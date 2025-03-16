package com.vazh2100.jetpackcompose.f_swipe_to_dismiss

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vazh2100.jetpackcompose.e_lazy_column.InstagramCard

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ListScreen(viewModel: MainViewModel, modifier: Modifier = Modifier) {

    val states = viewModel.isFollowed

    LazyColumn {
        items(items = states, key = { it.first }) {
            val dismissState = rememberSwipeToDismissBoxState()
            if (dismissState.currentValue == SwipeToDismissBoxValue.EndToStart) viewModel.deleteItem(it.first)
            SwipeToDismissBox(
                modifier = Modifier.animateItemPlacement(),
                state = dismissState,
                backgroundContent = {},
                enableDismissFromStartToEnd = false,
                content = {
                    InstagramCard(
                        followed = it.second,
                        onCardPress = { viewModel.changeFollowingStatus(it) },
                    )
                },
            )

        }
    }
}
