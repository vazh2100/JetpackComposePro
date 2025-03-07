package vazh2100.vk_client.e_material

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// Внутри column или row такая функция будет рисовать текст добавляя элемент в колонку или row
@Composable
fun ColumnScope.SomeFun(modifier: Modifier = Modifier) {
    repeat(10) {
        Text("text", modifier = modifier.weight(1f))
    }
}

@Composable
fun Example1() {
    OutlinedButton({}) {
        Text("Hello World")
    }
}

@Composable
fun Example2() {
    TextField("value", {}, label = { Text("Label") })
}

@Composable
fun Example3() {
    AlertDialog(
        onDismissRequest = {},
        confirmButton = { TextButton({}) { Text("да") } },
        dismissButton = { TextButton({}) { Text("нет") } },
        title = { Text("Заголовок") },
        text = { Text("Текст диалога") },
    )
}
