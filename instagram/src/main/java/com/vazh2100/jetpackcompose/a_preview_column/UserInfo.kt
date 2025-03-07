package com.vazh2100.jetpackcompose.a_preview_column

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun UserInfoPreview() = UserInfo(name = "Andrey", age = 30)

@Composable
fun UserInfo(name: String, age: Int, modifier: Modifier = Modifier) {
    Column {
        repeat(2) {
            Text(
                text = "Name: $name\nAge: $age",
                color = Color.Red,
                modifier = modifier
                    .background(Color.Blue)
                    .padding(12.dp)

            )
            Text(
                text = "Name: $name\nAge: $age",
                color = Color.Blue,
                modifier = modifier
                    .background(Color.Red)
                    .padding(12.dp)

            )
        }

    }
}
