package com.vazh2100.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TouchDetector(modifier: Modifier = Modifier) {

    val points = remember { mutableStateListOf<Offset>() }

    Canvas(
        modifier = modifier
            .pointerInput(Unit) { detectTapGestures(onTap = { points.add(it) }) }
            .pointerInput(Unit) {
                detectDragGestures(
                    onDrag = { change, _ ->
                        val newPoints = change.historical.map { it.position }
                        points.addAll(newPoints)
                    },
                )

            }) {
        drawPoints(
            points = points,
            pointMode = PointMode.Points,
            brush = Brush.linearGradient(colors = listOf(Color.Cyan, Color.Magenta, Color.Blue, Color.Yellow)),
            strokeWidth = 10.dp.toPx(),
            cap = StrokeCap.Round
        )
    }
}

