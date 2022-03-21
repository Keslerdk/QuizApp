package com.example.quizapp.ui.viewmodels

import android.content.ContentValues.TAG
import android.os.Build
import android.text.Html
import android.util.Log
import androidx.lifecycle.*
import com.example.quizapp.network.model.Categories
import com.example.quizapp.network.model.Questions
import com.example.quizapp.network.model.Result
import com.example.quizapp.repositories.MainRepo
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch
import javax.inject.Inject

class QuestionsViewModel @AssistedInject constructor(
    @Assisted private val categoryId: Int,
    private val mainRepo: MainRepo
) : ViewModel() {

    @Inject
    lateinit var offlineQuestions: List<String>

    private val _questionsList = MutableLiveData<List<Result>>()
    private val questionList: LiveData<List<Result>> get() = _questionsList

    private var _currentQuestionNum = MutableLiveData<Int>()
    val currentQuestionNum get() = _currentQuestionNum

    val currentQuestion: Result?
        get() {
            currentQuestionNum.value?.let {
                return questionList.value!![it]
            } ?: return null
        }

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status> get() = _status

    private var _chosenAnswer = ""

    private var _score = 0
    val score get() = _score


    init {
        getQuestionsList()
    }

    private fun getQuestionsList() {
        _status.value = Status.LOADING
        viewModelScope.launch {
            try {
                _questionsList.value =
                    mainRepo.getQuestionsList(categoryId = categoryId).results

                _currentQuestionNum.value = 0
                _status.value = Status.DONE
                Log.d(TAG, "getQuestionsList: ${questionList.value}")

            } catch (e: Exception) {
                _status.value = Status.ERROR
                parseOfflineData()
                Log.d(TAG, "getQuestionsList: $e")
            }

        }
    }

    /**
     * return scrambled list af answers
     */
    fun getAnswers(): List<String> {
        currentQuestion?.let {
            val answers = it.incorrect_answers.map { elem -> convertFromHtml(elem) }.toMutableList()
            answers.add(convertFromHtml(it.correct_answer))
            answers.shuffle()

            Log.d(TAG, "setAnswers: $answers")

            return answers
        } ?: return listOf()
    }

    fun getQuestion(): String {
        return convertFromHtml(currentQuestion!!.question)
    }

    fun setChosenAnswer(str: String) {
        _chosenAnswer = str
    }

    fun isAnswerRight(): Boolean {
        if (convertFromHtml(currentQuestion?.correct_answer ?: "") == _chosenAnswer) {
            _score++
            _chosenAnswer = ""
            return true
        }
        return false
    }

    fun setNextQuestion() {
        _currentQuestionNum.value =
            _currentQuestionNum.value!! + 1
    }

    private fun convertFromHtml(str: String): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(str, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            Html.fromHtml(str).toString()
        }
    }

    private fun parseOfflineData() {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val jsonAdapter : JsonAdapter<Questions> = moshi.adapter(Questions::class.java)
        when (categoryId) {
            11 -> _questionsList.value = jsonAdapter.fromJson(offlineQuestions[0])?.results
            10 -> _questionsList.value = jsonAdapter.fromJson(offlineQuestions[1])?.results
            9 -> _questionsList.value = jsonAdapter.fromJson(offlineQuestions[2])?.results
        }

        _currentQuestionNum.value =0
    }

    @AssistedFactory
    interface Factory {
        fun create(categoryId: Int): QuestionsViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: Factory,
            categoryId: Int
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create(categoryId) as T
            }
        }
    }
}