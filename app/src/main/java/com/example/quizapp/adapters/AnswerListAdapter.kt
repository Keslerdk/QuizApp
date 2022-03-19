package com.example.quizapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.databinding.AnswerItemBinding

class AnswerListAdapter(private val onClick: (String) -> Unit) :
    ListAdapter<String, AnswerListAdapter.AnswerListViewHolder>(DiffCallback) {

    private var selectedIndex = -1
    private var lastSelectedIndex = -1

    inner class AnswerListViewHolder(private val binding: AnswerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(text: String, position: Int) {
                binding.answerText.text = text
                binding.layout.isSelected = position==selectedIndex

                binding.answerCard.setOnClickListener {
                    onCardClick(position, text)
                }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerListViewHolder {
        val binding =
            AnswerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnswerListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnswerListViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    object DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }

    private fun onCardClick(position: Int, str: String) {
        onClick(str)

        lastSelectedIndex = selectedIndex
        selectedIndex = position

        notifyItemChanged(position)
        notifyItemChanged(lastSelectedIndex)
    }

}