package com.example.rangtech.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rangtech.databinding.ItemInspectionBinding
import com.example.rangtech.models.Inspection

class InspectionListAdapter(private val onClick: (Inspection) -> Unit) :
    ListAdapter<Inspection, InspectionListAdapter.InspectionViewHolder>(InspectionDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InspectionViewHolder {
        val binding = ItemInspectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InspectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InspectionViewHolder, position: Int) {
        val inspection = getItem(position)
        holder.bind(inspection, onClick)
    }

    class InspectionViewHolder(private val binding: ItemInspectionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(inspection: Inspection, onClick: (Inspection) -> Unit) {
            binding.inspectionTypeText.text = inspection.inspectionType.name
            binding.inspectionAreaText.text = inspection.area.name
            binding.root.setOnClickListener {
                onClick(inspection)
            }
        }
    }

    class InspectionDiffCallback : DiffUtil.ItemCallback<Inspection>() {
        override fun areItemsTheSame(oldItem: Inspection, newItem: Inspection): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Inspection, newItem: Inspection): Boolean {
            return oldItem == newItem
        }
    }
}