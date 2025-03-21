package vazh2100.vk_client.n_login.screens

sealed class LoginState {
    data object Logged : LoginState()
    data object Unlogged : LoginState()
}
