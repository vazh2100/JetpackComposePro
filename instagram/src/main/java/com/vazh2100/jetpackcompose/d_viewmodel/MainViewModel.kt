package com.vazh2100.jetpackcompose.d_viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _isFollowed = MutableLiveData(false)
    val isFollowed: LiveData<Boolean> = _isFollowed

    fun changeFollowingStatus() {
        val wasFollowing = _isFollowed.value!!
        _isFollowed.value = !wasFollowing
    }
}
