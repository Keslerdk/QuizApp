package com.example.quizapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.quizapp.databinding.AnswerItemBindingImpl;
import com.example.quizapp.databinding.BottomSheetBindingImpl;
import com.example.quizapp.databinding.CategoryItemBindingImpl;
import com.example.quizapp.databinding.FinalDialogBindingImpl;
import com.example.quizapp.databinding.FragmentCategoryBindingImpl;
import com.example.quizapp.databinding.FragmentQuestionsBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ANSWERITEM = 1;

  private static final int LAYOUT_BOTTOMSHEET = 2;

  private static final int LAYOUT_CATEGORYITEM = 3;

  private static final int LAYOUT_FINALDIALOG = 4;

  private static final int LAYOUT_FRAGMENTCATEGORY = 5;

  private static final int LAYOUT_FRAGMENTQUESTIONS = 6;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(6);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.quizapp.R.layout.answer_item, LAYOUT_ANSWERITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.quizapp.R.layout.bottom_sheet, LAYOUT_BOTTOMSHEET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.quizapp.R.layout.category_item, LAYOUT_CATEGORYITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.quizapp.R.layout.final_dialog, LAYOUT_FINALDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.quizapp.R.layout.fragment_category, LAYOUT_FRAGMENTCATEGORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.quizapp.R.layout.fragment_questions, LAYOUT_FRAGMENTQUESTIONS);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ANSWERITEM: {
          if ("layout/answer_item_0".equals(tag)) {
            return new AnswerItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for answer_item is invalid. Received: " + tag);
        }
        case  LAYOUT_BOTTOMSHEET: {
          if ("layout/bottom_sheet_0".equals(tag)) {
            return new BottomSheetBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bottom_sheet is invalid. Received: " + tag);
        }
        case  LAYOUT_CATEGORYITEM: {
          if ("layout/category_item_0".equals(tag)) {
            return new CategoryItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for category_item is invalid. Received: " + tag);
        }
        case  LAYOUT_FINALDIALOG: {
          if ("layout/final_dialog_0".equals(tag)) {
            return new FinalDialogBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for final_dialog is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCATEGORY: {
          if ("layout/fragment_category_0".equals(tag)) {
            return new FragmentCategoryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_category is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTQUESTIONS: {
          if ("layout/fragment_questions_0".equals(tag)) {
            return new FragmentQuestionsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_questions is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(3);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "fragment");
      sKeys.put(2, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(6);

    static {
      sKeys.put("layout/answer_item_0", com.example.quizapp.R.layout.answer_item);
      sKeys.put("layout/bottom_sheet_0", com.example.quizapp.R.layout.bottom_sheet);
      sKeys.put("layout/category_item_0", com.example.quizapp.R.layout.category_item);
      sKeys.put("layout/final_dialog_0", com.example.quizapp.R.layout.final_dialog);
      sKeys.put("layout/fragment_category_0", com.example.quizapp.R.layout.fragment_category);
      sKeys.put("layout/fragment_questions_0", com.example.quizapp.R.layout.fragment_questions);
    }
  }
}
