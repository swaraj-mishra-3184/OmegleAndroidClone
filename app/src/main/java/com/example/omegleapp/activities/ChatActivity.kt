package com.example.omegleapp.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.omegleapp.ui.ChatScreen
import com.example.omegleapp.ui.theme.OmegleAppTheme

class ChatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OmegleAppTheme {
                ChatScreen()
            }
        }
    }
}
