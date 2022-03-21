package com.example.quizapp;

import android.util.Log;
import android.view.View;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quizapp.adapters.CategoryListAdapter;
import com.example.quizapp.network.model.TriviaCategory;
import com.example.quizapp.ui.viewmodels.Status;
import com.facebook.shimmer.ShimmerFrameLayout;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0007\u001a\u001a\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007\u00a8\u0006\f"}, d2 = {"bindCategoryList", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "data", "", "Lcom/example/quizapp/network/model/TriviaCategory;", "bindLoading", "shimmerFrameLayout", "Lcom/facebook/shimmer/ShimmerFrameLayout;", "status", "Lcom/example/quizapp/ui/viewmodels/Status;", "app_debug"})
public final class BindingAdapterKt {
    
    @androidx.databinding.BindingAdapter(value = {"category_list"})
    public static final void bindCategoryList(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.quizapp.network.model.TriviaCategory> data) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"loading"})
    public static final void bindLoading(@org.jetbrains.annotations.NotNull()
    com.facebook.shimmer.ShimmerFrameLayout shimmerFrameLayout, @org.jetbrains.annotations.Nullable()
    com.example.quizapp.ui.viewmodels.Status status) {
    }
}