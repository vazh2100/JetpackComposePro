package com.vazh2100.canvas

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp

@Composable
fun Star(modifier: Modifier = Modifier) {

    val transition = rememberInfiniteTransition()
    val angle = transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(4500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
    )

    val brush = linearGradient(colors = listOf(Color.Cyan, Color.Magenta))
    Canvas(modifier = modifier.background(brush = brush)) {

        val color = Color.White
        val start = center + Offset(0f, -37.dp.toPx())
        val end = center + Offset(0f, -150.dp.toPx())
        val stroke = 5.dp.toPx()
        repeat(5) { a ->
            rotate(
                angle.value +
                        72f * a
            ) {
                repeat(2) { b ->
                    rotate(
                        angle.value +
                                -16f + 32f * b,
                        pivot = end
                    ) {
                        drawLine(
                            color = color,
                            start = start,
                            end = end,
                            strokeWidth = stroke
                        )
                    }
                }
            }
        }
    }
}
