package com.dabe.gamerepository.model;

import com.dabe.gamerepository.app.AppConsts;
import com.dabe.gamerepository.app.TheApp;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Scheduler;


/**
 * Created by Daniil Belevtsev on 12.01.2017 0:34.
 * Project: GameRepository; Skype: pandamoni1
 */

public class DataManager implements IDataManager {

    @Inject
    @Named(AppConsts.UI_THREAD)
    Scheduler uiThread;

    @Inject
    @Named(AppConsts.IO_THREAD)
    Scheduler ioThread;

    public DataManager() {
        TheApp.getComponent().inject(this);
    }
}
