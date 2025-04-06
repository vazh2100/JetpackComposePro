package com.vazh2100.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun Oleg2(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val letterWidth = 30.dp.toPx()
        val letterHeight = 50.dp.toPx()
        val space = 20.dp.toPx()
        val o = 0f
        val stroke = 5.dp.toPx()

        val startX = 110.dp.toPx()
        val startY = 320.dp.toPx()

        val path = Path().apply {
            // O
            moveTo(startX + letterWidth, startY)
            relativeLineTo(-letterWidth, o)
            relativeLineTo(o, letterHeight)
            relativeLineTo(letterWidth, o)
            relativeLineTo(o, -letterHeight)
            // L
            relativeMoveTo(space, o)
            relativeLineTo(o, letterHeight)
            relativeLineTo(letterWidth, o)
            // E
            relativeMoveTo(space + letterWidth, -letterHeight)
            relativeLineTo(-letterWidth, o)
            relativeLineTo(o, letterHeight)
            relativeLineTo(letterWidth, o)
            relativeMoveTo(-letterWidth, -letterHeight / 2)
            relativeLineTo(letterWidth, o)
            // G
            relativeMoveTo(space + letterWidth / 2, o)
            relativeLineTo(letterWidth / 2, o)
            relativeLineTo(o, letterHeight / 2)
            relativeLineTo(-letterWidth, o)
            relativeLineTo(o, -letterHeight)
            relativeLineTo(letterWidth, o)
        }
        val bounds = path.getBounds()

        val brush = linearGradient(
            colors = listOf(Color.DarkGray, Color.LightGray, Color.DarkGray),
            start = Offset(bounds.left, bounds.top),
            end = Offset(bounds.right, bounds.bottom),
        )
        drawPath(path = path, brush = brush, style = Stroke(stroke))

    }
}
