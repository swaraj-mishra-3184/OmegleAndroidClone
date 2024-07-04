package com.example.omegleapp.ui

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.omegleapp.activities.HomeActivity
import com.example.omegleapp.viewmodels.AuthViewModel
import com.example.omegleapp.drawables.*

@Composable
fun RegisterScreen(authViewModel: AuthViewModel = viewModel()) {
    val context = LocalContext.current
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = register.png), // Replace with your image resource
                contentDescription = "Register Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Create Your Account",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(24.dp))
            TextField(
                value = email.value,
                onValueChange = { email.value = it },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                label = { Text("Email") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = confirmPassword.value,
                onValueChange = { confirmPassword.value = it },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                label = { Text("Confirm Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    authViewModel.register(email.value, password.value) { success ->
                        if (success) {
                            context.startActivity(Intent(context, HomeActivity::class.java))
                        } else {
                            // Handle registration failure
                            // You can show an error message or toast here
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Text("Register")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    // Navigate back to LoginScreen
                    // You can implement navigation using Jetpack Navigation component or startActivity
                }
            ) {
                Text("Already have an account? Login here")
            }
        }
    }
}
