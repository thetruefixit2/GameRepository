package com.dabe.gamerepository.di.modules;

import com.dabe.gamerepository.model.DataManager;
import com.dabe.gamerepository.model.IDataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daniil Belevtsev on 12.01.2017 0:27.
 * Project: GameRepository; Skype: pandamoni1
 */

@Module
public class PresenterModule {

    @Provides
    @Singleton
    IDataManager provideDataManager() {
        return new DataManager();
    }

}
