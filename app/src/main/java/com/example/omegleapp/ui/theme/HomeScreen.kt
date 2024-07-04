package com.example.omegleapp.ui

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.omegleapp.activities.ChatActivity
import com.example.omegleapp.activities.VideoCallActivity
import com.example.omegleapp.activities.ProfileActivity
import com.example.omegleapp.viewmodels.HomeViewModel

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {
    val context = LocalContext.current
    val user by homeViewModel.currentUser.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Text(
                text = "Welcome to Omegle App",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Black
            )
            user?.let {
                Text(
                    text = "Hello, ${it.username}",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {
                        context.startActivity(Intent(context, ChatActivity::class.java))
                    },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                ) {
                    Text("Start Chat")
                }
                Button(
                    onClick = {
                        context.startActivity(Intent(context, VideoCallActivity::class.java))
                    },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                ) {
                    Text("Start Video Call")
                }
                Button(
                    onClick = {
                        context.startActivity(Intent(context, ProfileActivity::class.java))
                    },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                ) {
                    Text("View Profile")
                }
            } ?: run {
                Text("Loading user data...")
            }
        }
    }
}
