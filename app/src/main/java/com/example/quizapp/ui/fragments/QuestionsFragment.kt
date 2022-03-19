package com.example.quizapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.quizapp.R
import com.example.quizapp.adapters.AnswerListAdapter
import com.example.quizapp.databinding.FragmentQuestionsBinding
import com.example.quizapp.ui.viewmodels.QuestionViewModelFactory
import com.example.quizapp.ui.viewmodels.QuestionsViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior

class QuestionsFragment : Fragment() {
    private var _binding: FragmentQuestionsBinding? = null
    private val binding get() = _binding!!

    private val args: QuestionsFragmentArgs by navArgs()
    private val viewModel: QuestionsViewModel by viewModels {
        QuestionViewModelFactory(args.categoryId)
    }

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionsBinding.inflate(inflater, container, false)
        binding.fragment = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.title = args.categoryName

        bottomSheetBehavior = BottomSheetBehavior.from(binding.included.bottomSheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN


        val adapter = AnswerListAdapter { answer ->
            viewModel.setChosenAnswer(answer)
        }
        binding.answerList.adapter = adapter

        viewModel.currentQuestionNum.observe(this, {
            binding.questionText.text = viewModel.currentQuestion?.question
            binding.questionNum.text = getString(R.string.question_num, it + 1)

            adapter.submitList(viewModel.getAnswers())
        })
    }


    fun checkTheAnswer() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        bottomSheetBehavior.isHideable = false

        if (viewModel.isAnswerRight()) {
            binding.included.conclusion.text = getString(R.string.right)
            binding.included.someText.text = getString(R.string.right_text)
        } else {
            binding.included.conclusion.text = getString(R.string.wrong)
            binding.included.someText.text =
                getString(R.string.wrong_text, viewModel.currentQuestion?.correct_answer)
        }
    }
}