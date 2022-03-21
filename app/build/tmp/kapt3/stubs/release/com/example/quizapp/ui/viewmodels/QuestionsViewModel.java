package com.example.quizapp.ui.viewmodels;

import android.os.Build;
import android.text.Html;
import android.util.Log;
import androidx.lifecycle.*;
import com.example.quizapp.network.model.Categories;
import com.example.quizapp.network.model.Questions;
import com.example.quizapp.network.model.Result;
import com.example.quizapp.repositories.MainRepo;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u000201B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0002J\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\b0\fJ\u0006\u0010(\u001a\u00020\bJ\b\u0010)\u001a\u00020*H\u0002J\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u00020*H\u0002J\u000e\u0010.\u001a\u00020*2\u0006\u0010&\u001a\u00020\bJ\u0006\u0010/\u001a\u00020*R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u001d8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100\u001d8F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\u001f\u00a8\u00062"}, d2 = {"Lcom/example/quizapp/ui/viewmodels/QuestionsViewModel;", "Landroidx/lifecycle/ViewModel;", "categoryId", "", "mainRepo", "Lcom/example/quizapp/repositories/MainRepo;", "(ILcom/example/quizapp/repositories/MainRepo;)V", "_chosenAnswer", "", "_currentQuestionNum", "Landroidx/lifecycle/MutableLiveData;", "_questionsList", "", "Lcom/example/quizapp/network/model/Result;", "_score", "_status", "Lcom/example/quizapp/ui/viewmodels/Status;", "currentQuestion", "getCurrentQuestion", "()Lcom/example/quizapp/network/model/Result;", "currentQuestionNum", "getCurrentQuestionNum", "()Landroidx/lifecycle/MutableLiveData;", "offlineQuestions", "getOfflineQuestions", "()Ljava/util/List;", "setOfflineQuestions", "(Ljava/util/List;)V", "questionList", "Landroidx/lifecycle/LiveData;", "getQuestionList", "()Landroidx/lifecycle/LiveData;", "score", "getScore", "()I", "status", "getStatus", "convertFromHtml", "str", "getAnswers", "getQuestion", "getQuestionsList", "", "isAnswerRight", "", "parseOfflineData", "setChosenAnswer", "setNextQuestion", "Companion", "Factory", "app_release"})
public final class QuestionsViewModel extends androidx.lifecycle.ViewModel {
    private final int categoryId = 0;
    private final com.example.quizapp.repositories.MainRepo mainRepo = null;
    @javax.inject.Inject()
    public java.util.List<java.lang.String> offlineQuestions;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.quizapp.network.model.Result>> _questionsList = null;
    private androidx.lifecycle.MutableLiveData<java.lang.Integer> _currentQuestionNum;
    private final androidx.lifecycle.MutableLiveData<com.example.quizapp.ui.viewmodels.Status> _status = null;
    private java.lang.String _chosenAnswer = "";
    private int _score = 0;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.quizapp.ui.viewmodels.QuestionsViewModel.Companion Companion = null;
    
    @dagger.assisted.AssistedInject()
    public QuestionsViewModel(@dagger.assisted.Assisted()
    int categoryId, @org.jetbrains.annotations.NotNull()
    com.example.quizapp.repositories.MainRepo mainRepo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getOfflineQuestions() {
        return null;
    }
    
    public final void setOfflineQuestions(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    private final androidx.lifecycle.LiveData<java.util.List<com.example.quizapp.network.model.Result>> getQuestionList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getCurrentQuestionNum() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.quizapp.network.model.Result getCurrentQuestion() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.quizapp.ui.viewmodels.Status> getStatus() {
        return null;
    }
    
    public final int getScore() {
        return 0;
    }
    
    private final void getQuestionsList() {
    }
    
    /**
     * return scrambled list af answers
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getAnswers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getQuestion() {
        return null;
    }
    
    public final void setChosenAnswer(@org.jetbrains.annotations.NotNull()
    java.lang.String str) {
    }
    
    public final boolean isAnswerRight() {
        return false;
    }
    
    public final void setNextQuestion() {
    }
    
    private final java.lang.String convertFromHtml(java.lang.String str) {
        return null;
    }
    
    private final void parseOfflineData() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/quizapp/ui/viewmodels/QuestionsViewModel$Factory;", "", "create", "Lcom/example/quizapp/ui/viewmodels/QuestionsViewModel;", "categoryId", "", "app_release"})
    @dagger.assisted.AssistedFactory()
    public static abstract interface Factory {
        
        @org.jetbrains.annotations.NotNull()
        public abstract com.example.quizapp.ui.viewmodels.QuestionsViewModel create(int categoryId);
    }
    
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/example/quizapp/ui/viewmodels/QuestionsViewModel$Companion;", "", "()V", "provideFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "assistedFactory", "Lcom/example/quizapp/ui/viewmodels/QuestionsViewModel$Factory;", "categoryId", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.lifecycle.ViewModelProvider.Factory provideFactory(@org.jetbrains.annotations.NotNull()
        com.example.quizapp.ui.viewmodels.QuestionsViewModel.Factory assistedFactory, int categoryId) {
            return null;
        }
    }
}