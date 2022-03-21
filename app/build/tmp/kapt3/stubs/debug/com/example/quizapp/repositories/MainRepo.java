package com.example.quizapp.repositories;

import com.example.quizapp.network.QuizApiService;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/example/quizapp/repositories/MainRepo;", "", "quizApiService", "Lcom/example/quizapp/network/QuizApiService;", "(Lcom/example/quizapp/network/QuizApiService;)V", "getCategories", "Lcom/example/quizapp/network/model/Categories;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQuestionsList", "Lcom/example/quizapp/network/model/Questions;", "categoryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MainRepo {
    private final com.example.quizapp.network.QuizApiService quizApiService = null;
    
    @javax.inject.Inject()
    public MainRepo(@org.jetbrains.annotations.NotNull()
    com.example.quizapp.network.QuizApiService quizApiService) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.quizapp.network.model.Categories> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getQuestionsList(int categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.quizapp.network.model.Questions> continuation) {
        return null;
    }
}