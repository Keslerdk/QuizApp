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

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/example/quizapp/ui/viewmodels/Status;", "", "(Ljava/lang/String;I)V", "LOADING", "DONE", "ERROR", "app_debug"})
public enum Status {
    /*public static final*/ LOADING /* = new LOADING() */,
    /*public static final*/ DONE /* = new DONE() */,
    /*public static final*/ ERROR /* = new ERROR() */;
    
    Status() {
    }
}