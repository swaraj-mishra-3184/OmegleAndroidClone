package com.example.omegleapp.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.example.omegleapp.ui.HomeScreen
import com.example.omegleapp.ui.theme.OmegleAppTheme

class HomeActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OmegleAppTheme {
                HomeScreen()
            }
        }
    }
}