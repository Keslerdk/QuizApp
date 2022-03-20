package com.example.quizapp.di

import android.content.Context
import com.example.quizapp.network.BASE_URL
import com.example.quizapp.network.QuizApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.BufferedReader
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    @Singleton
    @Provides
    fun provideQuizApi(retrofit: Retrofit): QuizApiService =
        retrofit.create(QuizApiService::class.java)

    @Singleton
    @Provides
    fun provideOfflineQuestions(@ApplicationContext context: Context): List<String> =
        mutableListOf("quiz1.json", "quiz2.json", "quiz3.json").map { e ->
            context.assets.open(e)
                .bufferedReader()
                .use(BufferedReader::readText)
        }.toList()

    @Singleton
    @Provides
    fun provideOfflineCategories(@ApplicationContext context: Context): String =
        context.assets.open("categories.json")
            .bufferedReader()
            .use(BufferedReader::readText)


}