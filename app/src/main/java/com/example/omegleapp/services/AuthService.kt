package com.example.omegleapp.services

import com.google.firebase.auth.FirebaseAuth

class AuthService {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun login(email: String, password: String, onComplete: (Boolean) -> Unit) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            onComplete(task.isSuccessful)
        }
    }

    fun register(email: String, password: String, onComplete: (Boolean) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            onComplete(task.isSuccessful)
        }
    }
}
