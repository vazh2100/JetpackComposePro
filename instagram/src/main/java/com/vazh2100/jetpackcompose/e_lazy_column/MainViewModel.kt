package com.vazh2100.jetpackcompose.e_lazy_column

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel() {
    private val list = buildList { repeat(100) { add(Random.nextBoolean()) } }.toTypedArray()
    private val _isFollowed = mutableStateListOf(*list)
    val isFollowed = _isFollowed

    fun changeFollowingStatus(index: Int) {
        _isFollowed[index] = !_isFollowed[index]
    }
}
