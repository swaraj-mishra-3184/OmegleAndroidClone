package com.example.omegleapp.models

data class Chat(
    val chatId: String,
    val user1Id: String,
    val user2Id: String,
    val startedAt: Long
)
