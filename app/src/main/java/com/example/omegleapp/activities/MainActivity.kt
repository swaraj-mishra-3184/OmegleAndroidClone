package com.example.omegleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.omegleapp.ui.HomeScreen
import com.example.omegleapp.ui.theme.OmegleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OmegleAppTheme {
                HomeScreen()
            }
        }
    }
}
