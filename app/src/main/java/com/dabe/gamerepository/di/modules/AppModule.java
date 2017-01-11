package com.dabe.gamerepository.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daniil Belevtsev on 12.01.2017 0:46.
 * Project: GameRepository; Skype: pandamoni1
 */

@Module
public class AppModule {
    private Context appContext;

    public AppModule(Context appContext) {
        this.appContext = appContext;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return appContext;
    }
}
