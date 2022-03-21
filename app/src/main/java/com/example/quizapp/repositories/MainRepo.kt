package com.example.quizapp.repositories

import com.example.quizapp.network.QuizApiService
import javax.inject.Inject

class MainRepo @Inject constructor(private val quizApiService: QuizApiService) {

    suspend fun getCategories() = quizApiService.getCategories()
    suspend fun getQuestionsList(categoryId: Int) =
        quizApiService.getQuestionsList(categoryId = categoryId)
}