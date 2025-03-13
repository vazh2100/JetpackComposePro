package vazh2100.vk_client.i_view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vazh2100.vk_client.h_click_listeners.entities.FeedPost
import vazh2100.vk_client.h_click_listeners.entities.PostStatistics

class MainViewModel : ViewModel() {
    private val _feedPost: MutableLiveData<FeedPost> = MutableLiveData<FeedPost>(FeedPost())
    val feedPost: LiveData<FeedPost> = _feedPost

    fun onViewsPress() {
        _feedPost.value = _feedPost.value?.copy(statistics = statistics.copy(views = views + 1))
    }

    fun onSharesPress() {
        _feedPost.value = _feedPost.value?.copy(statistics = statistics.copy(shares = shares + 1))
    }

    fun onCommentsPress() {
        _feedPost.value = _feedPost.value?.copy(statistics = statistics.copy(comments = comments + 1))
    }

    fun onLikesPress() {
        _feedPost.value = _feedPost.value?.copy(statistics = statistics.copy(likes = likes + 1))
    }

    private val statistics: PostStatistics get() = _feedPost.value!!.statistics
    private val views get() = statistics.views
    private val shares get() = statistics.shares
    private val comments get() = statistics.comments
    private val likes get() = statistics.likes
}
