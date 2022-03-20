package com.example.quizapp.ui.viewmodels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.network.model.TriviaCategory
import com.example.quizapp.repositories.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class Status {
    LOADING, DONE, ERROR
}

@HiltViewModel
class CategoryViewModel @Inject constructor(private val mainRepo: MainRepo) : ViewModel() {
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
                Log.d(TAG, "getCategories: $e")
            }
        }
    }
}