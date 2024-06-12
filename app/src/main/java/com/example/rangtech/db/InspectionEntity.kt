package com.example.rangtech.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inspections")
data class InspectionEntity(
    @PrimaryKey val id: Int,
    val inspectionType: String,
    val area: String,
    val survey: String
)