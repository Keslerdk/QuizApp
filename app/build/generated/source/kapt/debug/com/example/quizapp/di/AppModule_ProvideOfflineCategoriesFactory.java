// Generated by Dagger (https://dagger.dev).
package com.example.quizapp.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideOfflineCategoriesFactory implements Factory<String> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideOfflineCategoriesFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public String get() {
    return provideOfflineCategories(contextProvider.get());
  }

  public static AppModule_ProvideOfflineCategoriesFactory create(
      Provider<Context> contextProvider) {
    return new AppModule_ProvideOfflineCategoriesFactory(contextProvider);
  }

  public static String provideOfflineCategories(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideOfflineCategories(context));
  }
}
