package com.example.omegleapp.utils

import com.google.firebase.database.FirebaseDatabase

object DatabaseUtils {
    private val database = FirebaseDatabase.getInstance()

    fun getUserReference(userId: String) = database.getReference("users").child(userId)
    fun getChatReference(chatId: String) = database.getReference("chats").child(chatId)
    fun getMessageReference(chatId: String) = database.getReference("messages").child(chatId)
}
