package com.example.omegleapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.omegleapp.models.User
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser

    init {
        loadUser()
    }

    private fun loadUser() {
        viewModelScope.launch {
            val firebaseUser = FirebaseAuth.getInstance().currentUser
            firebaseUser?.let {
                _currentUser.value = User(
                    userId = it.uid,
                    username = it.displayName ?: "Unknown",
                    email = it.email ?: "Unknown",
                    verified = it.isEmailVerified
                )
            }
        }
    }
}
