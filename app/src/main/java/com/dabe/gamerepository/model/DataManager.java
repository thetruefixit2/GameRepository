package com.dabe.gamerepository.model;

import com.dabe.gamerepository.app.TheApp;

/**
 * Created by Daniil Belevtsev on 12.01.2017 0:34.
 * Project: GameRepository; Skype: pandamoni1
 */

public class DataManager implements IDataManager {
    public DataManager() {
        TheApp.getComponent().inject(this);
    }
}
