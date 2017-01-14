package com.dabe.gamerepository.di.modules;

import com.dabe.gamerepository.presenter.presenters.GameListPresenter;
import com.dabe.gamerepository.presenter.presenters.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daniil Belevtsev on 12.01.2017 0:27.
 * Project: GameRepository; Skype: pandamoni1
 */

@Module
public class ViewModule {

    @Provides
    MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    GameListPresenter provideGameListPresenter() {
        return new GameListPresenter();
    }

}
