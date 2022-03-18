package com.example.quizapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.databinding.CategoryItemBinding
import com.example.quizapp.network.model.TriviaCategory
import kotlin.random.Random

class CategoryListAdapter :
    ListAdapter<TriviaCategory, CategoryListAdapter.CategoryViewHolder>(DiffCallback) {
    class CategoryViewHolder(private val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(text: String) {

            if (text.contains(":")) {
                binding.categoryName.text = text.split(":").last().substring(1)
            } else {
                binding.categoryName.text = text
            }

            binding.layout.apply {
                when(Random.nextInt(1, 5)) {
                    1 -> setBackgroundResource(R.drawable.card_background_1)
                    2 -> setBackgroundResource(R.drawable.card_background_2)
                    3 -> setBackgroundResource(R.drawable.card_background_3)
                    4 -> setBackgroundResource(R.drawable.card_background_4)
                }
            }
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<TriviaCategory>() {
        override fun areItemsTheSame(oldItem: TriviaCategory, newItem: TriviaCategory): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TriviaCategory, newItem: TriviaCategory): Boolean {
            return oldItem.name == newItem.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position).name)
    }
}