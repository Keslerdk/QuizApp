package com.example.quizapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quizapp.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private var _binding : FragmentCategoryBinding? = null
    private val binding get() = _binding!!

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
        return binding.root
    }

    fun navigateNext() {
        findNavController().navigate(R.id.action_categoryFragment_to_questionsFragment)
    }

}