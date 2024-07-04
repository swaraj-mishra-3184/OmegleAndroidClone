package com.example.omegleapp.services

import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase

class VideoCallService : ViewModel() {
    private val database = FirebaseDatabase.getInstance().reference

    fun startCall(userId: String) {
        val callData = mapOf("callerId" to userId, "timestamp" to System.currentTimeMillis())
        database.child("videoCalls").push().setValue(callData)
    }
}
