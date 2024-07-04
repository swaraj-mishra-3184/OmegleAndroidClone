package com.example.omegleapp.utils

import com.google.firebase.auth.FirebaseAuth

object AuthUtils {
    private val auth = FirebaseAuth.getInstance()

    fun isUserLoggedIn(): Boolean {
        return auth.currentUser != null
    }

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
