package com.example.rangtech.models

data class Question(
    val id: Int,
    val name: String,
    val answerChoices: List<AnswerChoice>,
    val selectedAnswerChoiceId: Int?
)