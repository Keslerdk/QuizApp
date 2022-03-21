package com.example.quizapp.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Questions(
    val response_code: Int,
    val results: List<Result>
)

@JsonClass(generateAdapter = true)
data class Result(
    val category: String,
    val correct_answer: String,
    val difficulty: String,
    val incorrect_answers: List<String>,
    val question: String,
    val type: String
)