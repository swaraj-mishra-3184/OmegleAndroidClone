package com.example.omegleapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.omegleapp.services.VideoCallService

@Composable
fun VideoCallScreen(videoCallService: VideoCallService = viewModel()) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        // Placeholder for video call UI
        Text(text = "Video Call Screen")
        Button(onClick = { videoCallService.startCall("userId") }) {
            Text("Start Call")
        }
    }
}
