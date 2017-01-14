package com.dabe.gamerepository.di.modules;

import com.dabe.gamerepository.app.AppConsts;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Daniil Belevtsev on 12.01.2017 0:27.
 * Project: GameRepository; Skype: pandamoni1
 */
@Module
public class ModelModule {

    @Provides
    @Singleton
    @Named(AppConsts.UI_THREAD)
    Scheduler provideSchedulerUI() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    @Named(AppConsts.IO_THREAD)
    Scheduler provideSchedulerIO() {
        return Schedulers.io();
    }
}
