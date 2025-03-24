package vazh2100.vk_client.presentation.screens.login

sealed class LoginState {
    data object Logged : LoginState()
    data object Unlogged : LoginState()
}
