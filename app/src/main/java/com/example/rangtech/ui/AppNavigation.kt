package com.example.rangtech.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rangtech.ui.screens.AuthScreen
import com.example.rangtech.ui.screens.HomeScreen
import com.example.rangtech.ui.screens.InspectionScreen

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = "auth") {
        composable("auth") { AuthScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("inspection/{inspectionId}") { backStackEntry ->
            val inspectionId = backStackEntry.arguments?.getString("inspectionId")?.toInt() ?: 0
            InspectionScreen(inspectionId)
        }
    }
}
