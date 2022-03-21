// Generated by Dagger (https://dagger.dev).
package com.example.quizapp.ui.viewmodels;

import com.example.quizapp.repositories.MainRepo;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CategoryViewModel_Factory implements Factory<CategoryViewModel> {
  private final Provider<MainRepo> mainRepoProvider;

  private final Provider<String> offlineCategoriesProvider;

  public CategoryViewModel_Factory(Provider<MainRepo> mainRepoProvider,
      Provider<String> offlineCategoriesProvider) {
    this.mainRepoProvider = mainRepoProvider;
    this.offlineCategoriesProvider = offlineCategoriesProvider;
  }

  @Override
  public CategoryViewModel get() {
    CategoryViewModel instance = newInstance(mainRepoProvider.get());
    CategoryViewModel_MembersInjector.injectOfflineCategories(instance, offlineCategoriesProvider.get());
    return instance;
  }

  public static CategoryViewModel_Factory create(Provider<MainRepo> mainRepoProvider,
      Provider<String> offlineCategoriesProvider) {
    return new CategoryViewModel_Factory(mainRepoProvider, offlineCategoriesProvider);
  }

  public static CategoryViewModel newInstance(MainRepo mainRepo) {
    return new CategoryViewModel(mainRepo);
  }
}
