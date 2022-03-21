package com.example.quizapp.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Categories(
    val trivia_categories: List<TriviaCategory>
)

@JsonClass(generateAdapter = true)
data class TriviaCategory(
    val id: Int,
    val name: String
)