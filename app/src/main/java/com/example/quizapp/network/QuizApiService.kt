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

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface QuizApiService {

    @GET("api_category.php")
    suspend fun getCategories(): Categories

    @GET("api.php")
    suspend fun getQuestionsList(
        @Query("amount") amount: Int = 5,
        @Query("category") categoryId: Int
        ): Questions
}

object QuizApi {
    val retrofitService: QuizApiService by lazy {
        retrofit.create(QuizApiService::class.java)
    }
}

