package com.vazh2100.jetpackcompose.f_swipe_to_dismiss

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel() {
    private val list = buildList { repeat(100) { add(it to Random.nextBoolean()) } }.toTypedArray()
    private val _isFollowed = mutableStateListOf(*list)
    val isFollowed = _isFollowed

    fun changeFollowingStatus(element: Pair<Int, Boolean>) {
        val index = _isFollowed.indexOf(element)
        val was = _isFollowed[index]
        _isFollowed[index] = was.copy(second = !was.second)
    }

    fun deleteItem(id: Int) {
        _isFollowed.removeIf { it.first == id }
    }
}
