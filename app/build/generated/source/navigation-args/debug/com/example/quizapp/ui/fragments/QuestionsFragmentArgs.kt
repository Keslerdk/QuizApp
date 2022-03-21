package com.example.quizapp.ui.fragments

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.String
import kotlin.jvm.JvmStatic

public data class QuestionsFragmentArgs(
  public val categoryName: String,
  public val categoryId: Int = 0
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("categoryId", this.categoryId)
    result.putString("categoryName", this.categoryName)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("categoryId", this.categoryId)
    result.set("categoryName", this.categoryName)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): QuestionsFragmentArgs {
      bundle.setClassLoader(QuestionsFragmentArgs::class.java.classLoader)
      val __categoryId : Int
      if (bundle.containsKey("categoryId")) {
        __categoryId = bundle.getInt("categoryId")
      } else {
        __categoryId = 0
      }
      val __categoryName : String?
      if (bundle.containsKey("categoryName")) {
        __categoryName = bundle.getString("categoryName")
        if (__categoryName == null) {
          throw IllegalArgumentException("Argument \"categoryName\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"categoryName\" is missing and does not have an android:defaultValue")
      }
      return QuestionsFragmentArgs(__categoryName, __categoryId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): QuestionsFragmentArgs {
      val __categoryId : Int?
      if (savedStateHandle.contains("categoryId")) {
        __categoryId = savedStateHandle["categoryId"]
        if (__categoryId == null) {
          throw IllegalArgumentException("Argument \"categoryId\" of type integer does not support null values")
        }
      } else {
        __categoryId = 0
      }
      val __categoryName : String?
      if (savedStateHandle.contains("categoryName")) {
        __categoryName = savedStateHandle["categoryName"]
        if (__categoryName == null) {
          throw IllegalArgumentException("Argument \"categoryName\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"categoryName\" is missing and does not have an android:defaultValue")
      }
      return QuestionsFragmentArgs(__categoryName, __categoryId)
    }
  }
}
