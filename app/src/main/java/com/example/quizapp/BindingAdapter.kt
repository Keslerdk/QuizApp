package com.example.quizapp

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.adapters.CategoryListAdapter
import com.example.quizapp.network.model.TriviaCategory

@BindingAdapter("category_list")
fun bindCategoryList(recyclerView: RecyclerView, data: List<TriviaCategory>?) {
    (recyclerView.adapter as CategoryListAdapter).submitList(data)
}