package com.example.rangtech.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.rangtech.viewmodel.AuthViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AuthScreen(navController: NavController) {
    val viewModel: AuthViewModel = hiltViewModel()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = password, onValueChange = { password = it }, label = { Text("Password") })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.login(email, password) }) {
            Text("Login")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { viewModel.register(email, password) }) {
            Text("Register")
        }

        val loginState by viewModel.loginState.collectAsState()
        loginState?.let {
            if (it.isSuccess) {
                navController.navigate("home")
            } else {
                Text("Login failed: ${it.exceptionOrNull()?.message}")
            }
        }

        val registerState by viewModel.registerState.collectAsState()
        registerState?.let {
            if (it.isSuccess) {
                navController.navigate("home")
            } else {
                Text("Registration failed: ${it.exceptionOrNull()?.message}")
            }
        }
    }
}