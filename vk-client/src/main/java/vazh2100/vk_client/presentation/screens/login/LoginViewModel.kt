package vazh2100.vk_client.presentation.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vk.id.AccessToken
import com.vk.id.VKID
import com.vk.id.VKIDAuthFail
import com.vk.id.auth.VKIDAuthCallback
import com.vk.id.auth.VKIDAuthParams
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.Instant

class LoginViewModel : ViewModel() {

    private val initial = if (VKID.instance.accessToken?.isValid == true) LoginState.Logged else LoginState.Unlogged
    private val _loginState = MutableStateFlow(initial)
    val loginState = _loginState.asStateFlow()

    fun onLoginPress() = viewModelScope.launch {
        VKID.instance.authorize(
            callback = CallBack(),
            params = VKIDAuthParams { this.scopes = setOf("friends", "wall") },
        )
    }

    inner class CallBack : VKIDAuthCallback {
        override fun onAuth(accessToken: AccessToken) {
            _loginState.value = LoginState.Logged
        }

        override fun onFail(fail: VKIDAuthFail) = run { _loginState.value = LoginState.Unlogged }
    }
}

val AccessToken.isValid get() = Instant.now().toEpochMilli() < expireTime
