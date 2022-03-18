package com.example.quizapp.ui.viewmodels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.network.QuizApi
import com.example.quizapp.network.model.TriviaCategory
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {
    private val _categories = MutableLiveData<List<TriviaCategory>>()
    val categories: LiveData<List<TriviaCategory>> get() = _categories

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            try {
                _categories.value = QuizApi.retrofitService.getCategories().trivia_categories
                Log.d(TAG, "getCategories: ${categories.value}")
            } catch (e: Exception) {
                Log.d(TAG, "getCategories: $e")
            }
        }
    }
}