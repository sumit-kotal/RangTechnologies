package com.example.rangtech.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rangtech.databinding.ActivityInspectionListBinding
import com.example.rangtech.viewmodel.InspectionListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InspectionListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInspectionListBinding
    private val inspectionListViewModel: InspectionListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInspectionListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = InspectionListAdapter { inspection ->
            val intent = Intent(this, InspectionDetailActivity::class.java).apply {
                putExtra("inspection_id", inspection.id)
            }
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        inspectionListViewModel.inspections.observe(this){ inspections ->
            adapter.submitList(inspections)
        }

        inspectionListViewModel.loadInspections()
    }
}
