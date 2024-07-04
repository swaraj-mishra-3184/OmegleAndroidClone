package com.example.omegleapp.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.omegleapp.ui.VideoCallScreen
import com.example.omegleapp.ui.theme.OmegleAppTheme

class VideoCallActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OmegleAppTheme {
                VideoCallScreen()
            }
        }
    }
}
