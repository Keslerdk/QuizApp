package com.example.quizapp.ui.viewmodels;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.quizapp.network.model.Categories;
import com.example.quizapp.network.model.TriviaCategory;
import com.example.quizapp.repositories.MainRepo;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/example/quizapp/ui/viewmodels/CategoryViewModel;", "Landroidx/lifecycle/ViewModel;", "mainRepo", "Lcom/example/quizapp/repositories/MainRepo;", "(Lcom/example/quizapp/repositories/MainRepo;)V", "_categories", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/quizapp/network/model/TriviaCategory;", "_status", "Lcom/example/quizapp/ui/viewmodels/Status;", "categories", "Landroidx/lifecycle/LiveData;", "getCategories", "()Landroidx/lifecycle/LiveData;", "offlineCategories", "", "getOfflineCategories", "()Ljava/lang/String;", "setOfflineCategories", "(Ljava/lang/String;)V", "status", "getStatus", "", "parseOfflineCategories", "app_debug"})
public final class CategoryViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.quizapp.repositories.MainRepo mainRepo = null;
    @javax.inject.Inject()
    public java.lang.String offlineCategories;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.quizapp.network.model.TriviaCategory>> _categories = null;
    private final androidx.lifecycle.MutableLiveData<com.example.quizapp.ui.viewmodels.Status> _status = null;
    
    @javax.inject.Inject()
    public CategoryViewModel(@org.jetbrains.annotations.NotNull()
    com.example.quizapp.repositories.MainRepo mainRepo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOfflineCategories() {
        return null;
    }
    
    public final void setOfflineCategories(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.quizapp.network.model.TriviaCategory>> getCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.quizapp.ui.viewmodels.Status> getStatus() {
        return null;
    }
    
    private final void getCategories() {
    }
    
    private final void parseOfflineCategories() {
    }
}