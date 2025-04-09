package com.vazh2100.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Star2(modifier: Modifier = Modifier) {

    val brush = linearGradient(colors = listOf(Color.Cyan, Color.Magenta))
    Canvas(modifier = modifier.background(brush = brush)) {
        val color = Color.White
        val stroke = 1.dp.toPx()
        val length = 125.dp.toPx()

        val path = Path().apply {
            moveTo(center.x, center.y - 1.5f * length)
            relativeLine(length, 90 - 18.0)
            relativeLine(length, 0.0)
            relativeLine(length, 180 - 36.0)
            relativeLine(length, 90 - 18.0)
            relativeLine(length, 180 + 36.0)
            relativeLine(length, 180 - 36.0)
            relativeLine(length, 270 + 18.0)
            relativeLine(length, 180 + 36.0)
            relativeLine(length, 0.0)
            relativeLine(length, 270 + 18.0)
        }

        drawPath(
            path = path, color = color,
            style = Stroke(stroke)
        )

    }
}

fun Path.relativeLine(length: Float, angle: Double) {
    val radians = Math.toRadians(angle)
    val x = 0f + length * cos(radians)
    val y = 0f + length * sin(radians)
    relativeLineTo(x.toFloat(), y.toFloat())
}


