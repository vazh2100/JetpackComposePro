import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AnimationsScreen() {
    Column(
        modifier = Modifier.fillMaxSize().padding(8.dp).verticalScroll(state = rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        val isFullSize = remember { mutableStateOf(true) }
        val isRounded = remember { mutableStateOf(true) }
        val isWithBorder = remember { mutableStateOf(false) }
        val isBlue = remember { mutableStateOf(true) }
        val isVisible = remember { mutableStateOf(true) }





        Box(
            modifier = Modifier.size(300.dp),
            contentAlignment = Alignment.Center,
        ) {
            AnimatedContainer(
                isFullSize = isFullSize,
                isRounded = isRounded,
                isWithBorder = isWithBorder,
                isBlue = isBlue,
                isVisible = isVisible,
            )
        }
        Button(
            modifier = Modifier.wrapContentSize(),
            onClick = { isFullSize.value = !isFullSize.value },
            content = {
                Text(text = "Size")
            },
        )
        Button(
            modifier = Modifier.wrapContentSize(),
            onClick = { isRounded.value = !isRounded.value },
            content = { Text(text = "Shape") },
        )
        Button(
            modifier = Modifier.wrapContentSize(),
            onClick = { isWithBorder.value = !isWithBorder.value },
            content = { Text(text = "Border") },
        )
        Button(
            modifier = Modifier.wrapContentSize(),
            onClick = { isBlue.value = !isBlue.value },
            content = { Text(text = "Color") })
        Button(
            modifier = Modifier.wrapContentSize(),
            onClick = { isVisible.value = !isVisible.value },
            content = { Text(text = "Visibility") },
        )
    }
}

@Composable
private fun AnimatedContainer(
    text: String = "Animated\nContainer",
    isFullSize: State<Boolean>,
    isRounded: State<Boolean>,
    isWithBorder: State<Boolean>,
    isBlue: State<Boolean>,
    isVisible: State<Boolean>,
) {

    val size = animateDpAsState(targetValue = if (isFullSize.value) 200.dp else 100.dp, animationSpec = tween())

    val corner = animateIntAsState(targetValue = if (isRounded.value) 4 else 50)
    val borderWidth = animateDpAsState(if (isWithBorder.value) 25.dp else 0.dp)
    val color =
        animateColorAsState(targetValue = if (isBlue.value) Color.Blue else Color.Cyan, animationSpec = spring())
    val visibility = animateFloatAsState(if (isVisible.value) 1f else 0f)

    val transition = rememberInfiniteTransition()
    val color2 by transition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Cyan,
        animationSpec = infiniteRepeatable(animation = tween(1500), repeatMode = RepeatMode.Reverse),
    )
    Box(
        modifier = Modifier
            .alpha(visibility.value)
            .size(size.value)
            .clip(RoundedCornerShape(corner.value))
            .border(borderWidth.value, color = color2, shape = RoundedCornerShape(corner.value))
            .background(color.value),

        contentAlignment = Alignment.Center,
    ) {
        Text(text = text, color = Color.White, textAlign = TextAlign.Center)
    }
}
