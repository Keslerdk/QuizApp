package com.example.quizapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import com.example.quizapp.adapters.CategoryListAdapter
import com.example.quizapp.databinding.FragmentCategoryBinding
import com.example.quizapp.ui.viewmodels.CategoryViewModel

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    private val viewModel : CategoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)

        binding.apply {
            fragment = this@CategoryFragment
            lifecycleOwner = this@CategoryFragment
        }

        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CategoryListAdapter()
        binding.categoryList.adapter = adapter

        viewModel
    }

    fun navigateNext() {
        findNavController().navigate(R.id.action_categoryFragment_to_questionsFragment)
    }

}