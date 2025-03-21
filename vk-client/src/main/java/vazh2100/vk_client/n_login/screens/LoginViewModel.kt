package vazh2100.vk_client.n_login.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vk.id.AccessToken
import com.vk.id.VKID
import com.vk.id.VKIDAuthFail
import com.vk.id.auth.VKIDAuthCallback
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Unlogged)
    val loginState = _loginState.asStateFlow()

    fun onLoginPress() = viewModelScope.launch { VKID.instance.authorize(callback = CallBack()) }

    inner class CallBack : VKIDAuthCallback {
        override fun onAuth(accessToken: AccessToken) = run { _loginState.value = LoginState.Logged }
        override fun onFail(fail: VKIDAuthFail) = run { _loginState.value = LoginState.Unlogged }
    }
}
