package animations

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedScreen(modifier: Modifier = Modifier) {

    var isFirst by remember { mutableStateOf(true) }

    Column(modifier = modifier.padding(32.dp)) {
        Button(
            onClick = { isFirst = !isFirst },
            content = { Text("Change") },
        )
        AnimatedContent(targetState = isFirst, transitionSpec = {
            if (targetState) {
                scaleIn(tween(1000)) togetherWith scaleOut(tween(1000))
            } else {
                slideInHorizontally(tween(1000)) { it } togetherWith slideOutHorizontally(tween(1000)) { -it }
            }

        }) {
            if (it) Screen1() else Screen2()

        }

    }
}

@Composable
fun Screen1(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize().background(color = Color.Blue))
}

@Composable
fun Screen2(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize().background(color = Color.Red))
}