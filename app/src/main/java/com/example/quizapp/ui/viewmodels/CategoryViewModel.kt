package com.example.quizapp.ui.viewmodels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.network.model.Categories
import com.example.quizapp.network.model.TriviaCategory
import com.example.quizapp.repositories.MainRepo
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class Status {
    LOADING, DONE, ERROR
}

@HiltViewModel
class CategoryViewModel @Inject constructor(private val mainRepo: MainRepo) : ViewModel() {

    @Inject
    lateinit var offlineCategories: String

    private val _categories = MutableLiveData<List<TriviaCategory>>()
    val categories: LiveData<List<TriviaCategory>> get() = _categories

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status> get() = _status

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            _status.value = Status.LOADING
            try {
                _categories.value = mainRepo.getCategories().trivia_categories
                _status.value = Status.DONE
                Log.d(TAG, "getCategories: ${categories.value}")
            } catch (e: Exception) {
                _status.value = Status.ERROR
                parseOfflineCategories()
                Log.d(TAG, "getCategories: $e")
            }
        }
    }

    private fun parseOfflineCategories() {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val jsonAdapter : JsonAdapter<Categories> = moshi.adapter(Categories::class.java)
        _categories.value = jsonAdapter.fromJson(offlineCategories)?.trivia_categories
    }
}