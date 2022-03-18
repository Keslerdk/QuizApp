package com.example.quizapp.network.model

data class Categories(
    val trivia_categories: List<TriviaCategory>
)

data class TriviaCategory(
    val id: Int,
    val name: String
)