package com.vazh2100.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Oleg(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val color = Color.White
        val stroke = 5.dp.toPx()

        val height = 50.dp.toPx()
        val width = 30.dp.toPx()

        val letterDiagonalShift = Offset(width, height)
        val letterHorizontalShift = Offset(width, 0f)
        val letterVerticalShift = Offset(0f, height)
        val space = 20.dp.toPx()
        val horizontalSpaceShift = Offset(space, 0f)

        val initialOffset = Offset(100.dp.toPx(), 50.dp.toPx())

        val oStart = initialOffset
        val oEnd = oStart + letterDiagonalShift

        val lStart = oStart + horizontalSpaceShift + letterHorizontalShift
        val lEnd = lStart + letterDiagonalShift

        val eStart = lStart + horizontalSpaceShift + letterHorizontalShift
        val eEnd = eStart + letterDiagonalShift

        val gStart = eStart + horizontalSpaceShift + letterHorizontalShift
        val gEnd = gStart + letterDiagonalShift

        // O
        drawLine(
            color = color,
            start = oStart,
            end = oEnd - letterVerticalShift,
            strokeWidth = stroke,
        )
        drawLine(
            color = color,
            start = oStart,
            end = oEnd - letterHorizontalShift,
            strokeWidth = stroke,
        )
        drawLine(
            color = color,
            start = oStart + letterVerticalShift,
            end = oEnd,
            strokeWidth = stroke,
        )
        drawLine(
            color = color,
            start = oStart + letterHorizontalShift,
            end = oEnd,
            strokeWidth = stroke,
        )

        // L
        drawLine(
            color = color,
            start = lStart,
            end = lStart + letterVerticalShift,
            strokeWidth = stroke,
        )
        drawLine(
            color = color,
            start = lStart + letterVerticalShift,
            end = lEnd,
            strokeWidth = stroke,
        )
        // E
        drawLine(
            color = color,
            start = eStart,
            end = eEnd - letterHorizontalShift,
            strokeWidth = stroke,
        )
        drawLine(
            color = color,
            start = eStart,
            end = eEnd - letterVerticalShift,
            strokeWidth = stroke,
        )
        drawLine(
            color = color,
            start = eStart + letterVerticalShift / 2f,
            end = eEnd - letterVerticalShift / 2f,
            strokeWidth = stroke,
        )
        drawLine(
            color = color,
            start = eStart + letterVerticalShift,
            end = eEnd,
            strokeWidth = stroke,
        )
        // G
        drawLine(
            color = color,
            start = gStart,
            end = gEnd - letterHorizontalShift,
            strokeWidth = stroke,
        )
        drawLine(
            color = color,
            start = gStart,
            end = gEnd - letterVerticalShift,
            strokeWidth = stroke,
        )
        drawLine(
            color = color,
            start = gStart + letterVerticalShift,
            end = gEnd,
            strokeWidth = stroke,
        )

        drawLine(
            color = color,
            start = gEnd,
            end = gEnd - letterVerticalShift / 2f,
            strokeWidth = stroke,
        )
        drawLine(
            color = color,
            start = gEnd - letterVerticalShift / 2f,
            end = gEnd - letterDiagonalShift / 2f,
            strokeWidth = stroke,
        )
    }
}
