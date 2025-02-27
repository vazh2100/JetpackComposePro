package com.vazh2100.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            UserInfo("Andrey", 30)
        }
    }
}

@Composable
fun UserInfo(name: String, age: Int, modifier: Modifier = Modifier) {
    Text(
        text = "Name: $name\nAge: $age",
        modifier = modifier
    )
}
