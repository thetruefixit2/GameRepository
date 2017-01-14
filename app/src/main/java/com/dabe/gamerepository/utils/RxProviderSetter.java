package com.dabe.gamerepository.utils;

import com.dabe.gamerepository.model.data.dto.IGGame;
import com.dabe.gamerepository.model.data.enums.DataProvideEnum;

import rx.functions.Func1;

/**
 * Created by Daniil Belevtsev on 14.01.2017 19:32.
 * Project: GameRepository; Skype: pandamoni1
 */

public class RxProviderSetter implements Func1<IGGame, IGGame> {
    private DataProvideEnum provider;

    public RxProviderSetter(DataProvideEnum provider) {
        this.provider = provider;
    }

    @Override
    public IGGame call(IGGame igGame) {
        igGame.setDataProvider(provider);
        return igGame;
    }
}
