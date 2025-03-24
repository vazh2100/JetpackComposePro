package vazh2100.vk_client.presentation.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import vazh2100.vk_client.MainScreen
import vazh2100.vk_client.R
import vazh2100.vk_client.presentation.theme.darkBlue

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(), modifier: Modifier = Modifier
) {
    val state by viewModel.loginState.collectAsState()

    when (state) {
        LoginState.Logged -> {
            MainScreen()
        }
        LoginState.Unlogged -> {
            LoginContent(viewModel = viewModel)
        }
    }
}

@Composable
fun LoginContent(
    viewModel: LoginViewModel, modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = modifier.wrapContentSize().padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(R.drawable.vk_logo),
                contentDescription = "vk_logo",
            )
            Spacer(Modifier.height(100.dp))
            Button(
                onClick = viewModel::onLoginPress,
                content = { Text("Login") },
                colors = ButtonDefaults.buttonColors(containerColor = darkBlue)
            )
        }
    }
}
