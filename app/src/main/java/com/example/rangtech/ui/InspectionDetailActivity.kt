package com.example.rangtech.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.rangtech.databinding.ActivityInspectionDetailBinding
import com.example.rangtech.viewmodel.InspectionDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InspectionDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInspectionDetailBinding
    private val inspectionDetailViewModel: InspectionDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInspectionDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inspectionId = intent.getIntExtra("inspection_id", -1)
        if (inspectionId != -1) {
            inspectionDetailViewModel.loadInspection(inspectionId)
        }

        inspectionDetailViewModel.inspection.observe(this) { inspection ->
            // Update UI with inspection data
            binding.inspectionTypeText.text = inspection.inspectionType.name
            binding.inspectionAreaText.text = inspection.area.name
            // Handle other UI updates
        }

        binding.submitButton.setOnClickListener {
            // Collect data and submit inspection
            inspectionDetailViewModel.submitInspection()
        }
    }
}