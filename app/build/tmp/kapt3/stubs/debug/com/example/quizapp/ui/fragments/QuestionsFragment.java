package com.example.quizapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.example.quizapp.R;
import com.example.quizapp.adapters.AnswerListAdapter;
import com.example.quizapp.databinding.FinalDialogBinding;
import com.example.quizapp.databinding.FragmentQuestionsBinding;
import com.example.quizapp.ui.viewmodels.QuestionsViewModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u001eH\u0002J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\u001a\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u0010*\u001a\u00020\u001eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006+"}, d2 = {"Lcom/example/quizapp/ui/fragments/QuestionsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/quizapp/databinding/FragmentQuestionsBinding;", "args", "Lcom/example/quizapp/ui/fragments/QuestionsFragmentArgs;", "getArgs", "()Lcom/example/quizapp/ui/fragments/QuestionsFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "binding", "getBinding", "()Lcom/example/quizapp/databinding/FragmentQuestionsBinding;", "bottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "viewModel", "Lcom/example/quizapp/ui/viewmodels/QuestionsViewModel;", "getViewModel", "()Lcom/example/quizapp/ui/viewmodels/QuestionsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewModelAssistedFactory", "Lcom/example/quizapp/ui/viewmodels/QuestionsViewModel$Factory;", "getViewModelAssistedFactory", "()Lcom/example/quizapp/ui/viewmodels/QuestionsViewModel$Factory;", "setViewModelAssistedFactory", "(Lcom/example/quizapp/ui/viewmodels/QuestionsViewModel$Factory;)V", "checkTheAnswer", "", "navigateToNextQuestion", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "showFinalDialog", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class QuestionsFragment extends androidx.fragment.app.Fragment {
    private com.example.quizapp.databinding.FragmentQuestionsBinding _binding;
    @javax.inject.Inject()
    public com.example.quizapp.ui.viewmodels.QuestionsViewModel.Factory viewModelAssistedFactory;
    private final androidx.navigation.NavArgsLazy args$delegate = null;
    private final kotlin.Lazy viewModel$delegate = null;
    private com.google.android.material.bottomsheet.BottomSheetBehavior<androidx.constraintlayout.widget.ConstraintLayout> bottomSheetBehavior;
    
    public QuestionsFragment() {
        super();
    }
    
    private final com.example.quizapp.databinding.FragmentQuestionsBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.quizapp.ui.viewmodels.QuestionsViewModel.Factory getViewModelAssistedFactory() {
        return null;
    }
    
    public final void setViewModelAssistedFactory(@org.jetbrains.annotations.NotNull()
    com.example.quizapp.ui.viewmodels.QuestionsViewModel.Factory p0) {
    }
    
    private final com.example.quizapp.ui.fragments.QuestionsFragmentArgs getArgs() {
        return null;
    }
    
    private final com.example.quizapp.ui.viewmodels.QuestionsViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void checkTheAnswer() {
    }
    
    private final void navigateToNextQuestion() {
    }
    
    private final void showFinalDialog() {
    }
}