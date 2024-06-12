package com.example.rangtech.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rangtech.viewmodel.InspectionViewModel

@Composable
fun InspectionScreen(inspectionId: Int) {
    val viewModel: InspectionViewModel = hiltViewModel()
    val inspection by viewModel.inspection.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        inspection?.let {
            Text("Inspection: ${it.area.name}")
            // Display inspection details and survey
            // Handle survey responses and submission
        }
    }
}
