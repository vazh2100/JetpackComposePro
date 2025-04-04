import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun CanvasWidget(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {

        drawLine(
            color = Color.White, start = Offset(50.dp.toPx(), 50.dp.toPx()), end = Offset(1000.dp.toPx(), 50.dp.toPx())
        )
        drawLine(
            color = Color.White,
            start = Offset(1000.dp.toPx(), 50.dp.toPx()),
            end = Offset(1000.dp.toPx(), 1000.dp.toPx())
        )
        drawLine(
            color = Color.White,
            start = Offset(1000.dp.toPx(), 1000.dp.toPx()),
            end = Offset(50.dp.toPx(), 50.dp.toPx())
        )

        drawLine(color = Color.Yellow, start = Offset(0.dp.toPx(), 0.dp.toPx()), end = Offset(size.width, size.height))
        drawLine(color = Color.Yellow, start = Offset(size.width, 0.dp.toPx()), end = Offset(0.dp.toPx(), size.height))

        drawCircle(color = Color.Blue, radius = size.width / 4, style = Stroke(width = 5.dp.toPx()))
    }
}