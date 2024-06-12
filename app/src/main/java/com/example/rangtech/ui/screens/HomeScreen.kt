package com.example.rangtech.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rangtech.viewmodel.InspectionViewModel

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: InspectionViewModel = hiltViewModel()
    val inspectionList by viewModel.inspectionList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = { viewModel.startInspection() }) {
            Text("Start New Inspection")
        }
        Spacer(modifier = Modifier.height(16.dp))

        inspectionList.forEach { inspection ->
            Text(inspection.area.name)
            // Additional UI elements for inspection details
            Spacer(modifier = Modifier.height(8.dp))
        }

        val inspection by viewModel.inspection.collectAsState()
        inspection?.let {
            // Navigate to inspection details
            navController.navigate("inspection/${it.id}")
        }
    }
}
