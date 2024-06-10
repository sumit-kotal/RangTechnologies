package com.example.rangtech.models

data class Category(
    val id: Int,
    val name: String,
    val questions: List<Question>
)