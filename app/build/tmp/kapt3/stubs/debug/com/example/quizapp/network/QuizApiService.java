package com.example.quizapp.network;

import com.example.quizapp.network.model.Categories;
import com.example.quizapp.network.model.Questions;
import retrofit2.http.GET;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/example/quizapp/network/QuizApiService;", "", "getCategories", "Lcom/example/quizapp/network/model/Categories;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQuestionsList", "Lcom/example/quizapp/network/model/Questions;", "amount", "", "categoryId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface QuizApiService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "api_category.php")
    public abstract java.lang.Object getCategories(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.quizapp.network.model.Categories> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "api.php")
    public abstract java.lang.Object getQuestionsList(@retrofit2.http.Query(value = "amount")
    int amount, @retrofit2.http.Query(value = "category")
    int categoryId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.quizapp.network.model.Questions> continuation);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
}