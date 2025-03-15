package com.vazh2100.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.vazh2100.jetpackcompose.c_instagram.JetpackComposeTheme
import com.vazh2100.jetpackcompose.e_lazy_column.ListScreen
import com.vazh2100.jetpackcompose.e_lazy_column.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainViewModel::class]
        setContent {
            JetpackComposeTheme {
                Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(8.dp)) {
                    ListScreen(viewModel)
                }
            }
        }
    }
}
