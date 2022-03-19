package com.example.quizapp.ui.fragments

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.quizapp.adapters.AnswerListAdapter
import com.example.quizapp.databinding.FragmentQuestionsBinding
import com.example.quizapp.ui.viewmodels.QuestionViewModelFactory
import com.example.quizapp.ui.viewmodels.QuestionsViewModel

class QuestionsFragment : Fragment() {
    private var _binding: FragmentQuestionsBinding? = null
    private val binding get() = _binding!!

    private val args: QuestionsFragmentArgs by navArgs()
    private val viewModel: QuestionsViewModel by viewModels {
        QuestionViewModelFactory(args.categoryId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AnswerListAdapter()

        viewModel.currentQuestion.observe(this, {
            binding.questionText.text = convertFromHtml(it.question)

            adapter.submitList(viewModel.setAnswers())
        })

        binding.answerList.adapter = adapter
    }

    private fun convertFromHtml(str: String): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(str, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            Html.fromHtml(str).toString()
        }
    }
}