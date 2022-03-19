package com.example.quizapp.ui.viewmodels

import android.content.ContentValues.TAG
import android.os.Build
import android.text.Html
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

    private var _currentQuestionNum = MutableLiveData<Int>()
    val currentQuestionNum get() = _currentQuestionNum

    val currentQuestion: Result?
        get() {
            currentQuestionNum.value?.let {
                return questionList.value!![it]
            } ?: return null
        }

    private var _chosenAnswer = ""


    init {
        getQuestionsList()
    }

    private fun getQuestionsList() {
        viewModelScope.launch {
            try {
                _questionsList.value =
                    QuizApi.retrofitService.getQuestionsList(categoryId = categoryId).results

                _currentQuestionNum.value = 0
                parseResult()
                Log.d(TAG, "getQuestionsList: ${questionList.value}")

            } catch (e: Exception) {
                Log.d(TAG, "getQuestionsList: $e")
            }

        }
    }

    /**
     * return scrambled list af answers
     */
    fun getAnswers(): List<String> {
        currentQuestion?.let {
            val answers = it.incorrect_answers.toMutableList()
            answers.add(convertFromHtml(it.correct_answer))
            answers.shuffle()

            Log.d(TAG, "setAnswers: $answers")

            return answers
        } ?: return listOf()
    }

    fun setChosenAnswer(str: String) {
        _chosenAnswer = str
    }

    fun isAnswerRight(): Boolean {
        if (currentQuestion?.correct_answer.equals(_chosenAnswer)) {
            _chosenAnswer = ""
            return true
        }
        return false
    }

    /**
     * convert from html code to plain text
     * and rewrite some properties
     */
    private fun parseResult() {
        currentQuestion?.let {
            it.correct_answer = convertFromHtml(it.correct_answer)
            it.question = convertFromHtml(it.question)
            it.incorrect_answers.map { elem -> convertFromHtml(elem)  }.toList()
        }
        currentQuestion!!.correct_answer = convertFromHtml(currentQuestion!!.correct_answer)
    }

    private fun convertFromHtml(str: String): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(str, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            Html.fromHtml(str).toString()
        }
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