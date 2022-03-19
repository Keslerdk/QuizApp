package com.example.quizapp.network.model

data class Questions(
    val response_code: Int,
    val results: List<Result>
)

data class Result(
    val category: String,
    var correct_answer: String,
    val difficulty: String,
    val incorrect_answers: List<String>,
    var question: String,
    val type: String
)