package com.example.quizapp.ui.viewmodels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.*
import com.example.quizapp.network.QuizApi
import com.example.quizapp.network.model.Result
import kotlinx.coroutines.launch

class QuestionsViewModel(
    private val categoryId: Int
) : ViewModel() {

    private val _questionsList = MutableLiveData<List<Result>>()
    val questionList: LiveData<List<Result>> get() = _questionsList

    private val _currentQuestion = MutableLiveData<Result>()
    val currentQuestion: LiveData<Result> get() = _currentQuestion

    private var _correctAnswer: String? = null
    val correctAnswer get() = _correctAnswer!!

    init {
        getQuestionsList()
    }

    private fun getQuestionsList() {
        viewModelScope.launch {
            try {
                _questionsList.value =
                    QuizApi.retrofitService.getQuestionsList(categoryId = categoryId).results

                _currentQuestion.value = questionList.value?.get(0)
                _correctAnswer = currentQuestion.value?.correct_answer

                Log.d(TAG, "getQuestionsList: ${questionList.value}")

            } catch (e: Exception) {
                Log.d(TAG, "getQuestionsList: $e")
            }

        }
    }

    fun setAnswers(): List<String> {
        currentQuestion.value?.let {
            val answers = it.incorrect_answers.toMutableList()
            answers.add(it.correct_answer)
            answers.shuffle()

            Log.d(TAG, "setAnswers: $answers")

            return answers
        } ?: return listOf()
    }
}

class QuestionViewModelFactory(private val categoryId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuestionsViewModel::class.java)) {
            return QuestionsViewModel(categoryId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}