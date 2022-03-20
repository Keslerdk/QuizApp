package com.example.quizapp.network

import com.example.quizapp.network.model.Categories
import com.example.quizapp.network.model.Questions
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://opentdb.com"

interface QuizApiService {

    @GET("api_category.php")
    suspend fun getCategories(): Categories

    @GET("api.php")
    suspend fun getQuestionsList(
        @Query("amount") amount: Int = 5,
        @Query("category") categoryId: Int
        ): Questions
}

