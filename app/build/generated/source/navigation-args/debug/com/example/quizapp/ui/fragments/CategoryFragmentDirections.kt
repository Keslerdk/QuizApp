package com.example.quizapp.ui.fragments

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.quizapp.R
import kotlin.Int
import kotlin.String

public class CategoryFragmentDirections private constructor() {
  private data class ActionCategoryFragmentToQuestionsFragment(
    public val categoryName: String,
    public val categoryId: Int = 0
  ) : NavDirections {
    public override val actionId: Int = R.id.action_categoryFragment_to_questionsFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("categoryId", this.categoryId)
        result.putString("categoryName", this.categoryName)
        return result
      }
  }

  public companion object {
    public fun actionCategoryFragmentToQuestionsFragment(categoryName: String, categoryId: Int = 0):
        NavDirections = ActionCategoryFragmentToQuestionsFragment(categoryName, categoryId)
  }
}
