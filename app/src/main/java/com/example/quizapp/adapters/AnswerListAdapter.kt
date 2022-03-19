package com.example.quizapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.databinding.QuestionItemBinding

class AnswerListAdapter :
    ListAdapter<String, AnswerListAdapter.AnswerListViewHolder>(DiffCallback) {

    inner class AnswerListViewHolder(private val binding: QuestionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(text: String) {
                binding.answerText.text = text
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerListViewHolder {
        val binding =
            QuestionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnswerListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnswerListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }

}