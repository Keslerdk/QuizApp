// Generated by Dagger (https://dagger.dev).
package com.example.quizapp.ui.viewmodels;

import com.example.quizapp.repositories.MainRepo;
import dagger.internal.DaggerGenerated;
import java.util.List;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class QuestionsViewModel_Factory {
  private final Provider<MainRepo> mainRepoProvider;

  private final Provider<List<String>> offlineQuestionsProvider;

  public QuestionsViewModel_Factory(Provider<MainRepo> mainRepoProvider,
      Provider<List<String>> offlineQuestionsProvider) {
    this.mainRepoProvider = mainRepoProvider;
    this.offlineQuestionsProvider = offlineQuestionsProvider;
  }

  public QuestionsViewModel get(int categoryId) {
    QuestionsViewModel instance = newInstance(categoryId, mainRepoProvider.get());
    QuestionsViewModel_MembersInjector.injectOfflineQuestions(instance, offlineQuestionsProvider.get());
    return instance;
  }

  public static QuestionsViewModel_Factory create(Provider<MainRepo> mainRepoProvider,
      Provider<List<String>> offlineQuestionsProvider) {
    return new QuestionsViewModel_Factory(mainRepoProvider, offlineQuestionsProvider);
  }

  public static QuestionsViewModel newInstance(int categoryId, MainRepo mainRepo) {
    return new QuestionsViewModel(categoryId, mainRepo);
  }
}
