package com.dabe.gamerepository.model;

import com.dabe.gamerepository.app.AppConsts;
import com.dabe.gamerepository.app.TheApp;
import com.dabe.gamerepository.model.api.ISteamApi;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;


/**
 * Created by Daniil Belevtsev on 12.01.2017 0:34.
 * Project: GameRepository; Skype: pandamoni1
 */

public class DataManager implements IDataManager {

    private final Observable.Transformer shedulersTransformer;

    @Inject
    ISteamApi steamApi;

    @Inject
    @Named(AppConsts.UI_THREAD)
    Scheduler uiThread;

    @Inject
    @Named(AppConsts.IO_THREAD)
    Scheduler ioThread;

    public DataManager() {
        TheApp.getComponent().inject(this);
        shedulersTransformer = observable -> ((Observable) observable).subscribeOn(ioThread)
                .observeOn(uiThread)
                .unsubscribeOn(ioThread);
    }

    @SuppressWarnings("unchecked")
    private <T> Observable.Transformer<T, T> applyShedulers() {
        return (Observable.Transformer<T, T>) shedulersTransformer;
    }
}
