package com.example.omegleapp.services

import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase

class ChatService : ViewModel() {
    private val database = FirebaseDatabase.getInstance().reference

    fun sendMessage(chatId: String, message: String) {
        val messageData = mapOf("message" to message, "timestamp" to System.currentTimeMillis())
        database.child("chats").child(chatId).push().setValue(messageData)
    }
}
