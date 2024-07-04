package com.example.omegleapp.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.omegleapp.ui.theme.OmegleAppTheme
import com.example.omegleapp.ui.RegisterScreen

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OmegleAppTheme {
                RegisterScreen()
            }
        }
    }
}
