package com.example.quizapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
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

    private val viewModel: CategoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)

        binding.apply {
            lifecycleOwner = this@CategoryFragment
            viewModel = this@CategoryFragment.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            getString(R.string.categories)

        val adapter = CategoryListAdapter { id -> navigateToDetails(id) }
        binding.categoryList.adapter = adapter

    }

    private fun navigateToDetails(categoryId: Int) {
        val action = CategoryFragmentDirections.actionCategoryFragmentToQuestionsFragment(categoryId)
        findNavController().navigate(action)
    }

}