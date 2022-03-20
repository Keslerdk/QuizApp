package com.example.quizapp

import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.adapters.CategoryListAdapter
import com.example.quizapp.network.model.TriviaCategory
import com.example.quizapp.ui.viewmodels.Status
import com.facebook.shimmer.ShimmerFrameLayout

@BindingAdapter("category_list")
fun bindCategoryList(recyclerView: RecyclerView, data: List<TriviaCategory>?) {
    (recyclerView.adapter as CategoryListAdapter).submitList(data)
}

@BindingAdapter("loading")
fun bindLoading(shimmerFrameLayout: ShimmerFrameLayout, status: Status?) {
    Log.d(TAG, "bindLoading: $status")

    if (status == Status.LOADING) {
        shimmerFrameLayout.visibility = View.VISIBLE
    } else {
        shimmerFrameLayout.visibility = View.INVISIBLE
    }
}