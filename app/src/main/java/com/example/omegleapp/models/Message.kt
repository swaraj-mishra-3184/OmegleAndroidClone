package com.example.omegleapp.models

data class Message(
    val messageId: String,
    val chatId: String,
    val senderId: String,
    val message: String,
    val sentAt: Long
)
