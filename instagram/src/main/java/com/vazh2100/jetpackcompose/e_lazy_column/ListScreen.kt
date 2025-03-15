package com.vazh2100.jetpackcompose.e_lazy_column

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ListScreen(viewModel: MainViewModel, modifier: Modifier = Modifier) {
    val states = viewModel.isFollowed

    LazyColumn {
        itemsIndexed(states, key = { i, _ -> i }) { index, it ->
            InstagramCard(
                followed = it,
                onCardPress = { viewModel.changeFollowingStatus(index) },
            )
        }
    }
}
