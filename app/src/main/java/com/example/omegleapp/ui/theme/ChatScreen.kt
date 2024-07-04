package com.example.omegleapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.omegleapp.services.ChatService

@Composable
fun ChatScreen(chatService: ChatService = viewModel()) {
    val message = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        // Display messages (add logic to display messages here)
        TextField(value = message.value, onValueChange = { message.value = it }, label = { Text("Message") })
        Button(onClick = { chatService.sendMessage("chatId", message.value) }) {
            Text("Send")
        }
    }
}
