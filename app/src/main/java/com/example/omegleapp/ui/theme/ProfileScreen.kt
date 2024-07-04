package com.example.omegleapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.omegleapp.models.User
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfileScreen() {
    val currentUser = FirebaseAuth.getInstance().currentUser

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        currentUser?.let {
            Text(text = "Username: ${it.displayName ?: "Unknown"}")
            Text(text = "Email: ${it.email ?: "Unknown"}")
            Text(text = "Verified: ${it.isEmailVerified}")
        } ?: run {
            Text(text = "No user information available.")
        }
    }
}
