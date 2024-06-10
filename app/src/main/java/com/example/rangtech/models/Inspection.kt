package com.example.rangtech.models

data class Inspection(
    val id: Int,
    val inspectionType: InspectionType,
    val area: Area,
    val survey: Survey
)