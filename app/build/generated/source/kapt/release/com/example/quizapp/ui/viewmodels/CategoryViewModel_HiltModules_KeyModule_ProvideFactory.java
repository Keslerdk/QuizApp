// Generated by Dagger (https://dagger.dev).
package com.example.quizapp.ui.viewmodels;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CategoryViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
  @Override
  public String get() {
    return provide();
  }

  public static CategoryViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provide() {
    return Preconditions.checkNotNullFromProvides(CategoryViewModel_HiltModules.KeyModule.provide());
  }

  private static final class InstanceHolder {
    private static final CategoryViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new CategoryViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}
