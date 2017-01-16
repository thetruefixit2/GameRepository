package com.dabe.gamerepository.utils;

import com.dabe.gamerepository.model.data.dto.SteamGame;
import com.dabe.gamerepository.model.data.enums.DataProvideEnum;

import rx.functions.Func1;

/**
 * Created by Daniil Belevtsev on 14.01.2017 19:32.
 * Project: GameRepository; Skype: pandamoni1
 */

public class SteamProviderSetter implements Func1<SteamGame, SteamGame> {
    private DataProvideEnum provider;

    public SteamProviderSetter(DataProvideEnum provider) {
        this.provider = provider;
    }

    @Override
    public SteamGame call(SteamGame steamGame) {
        steamGame.setDataProvider(provider);
        return steamGame;
    }
}
