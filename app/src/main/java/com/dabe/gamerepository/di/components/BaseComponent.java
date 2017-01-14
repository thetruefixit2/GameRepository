package com.dabe.gamerepository.di.components;

import com.dabe.gamerepository.di.modules.AppModule;
import com.dabe.gamerepository.di.modules.ModelModule;
import com.dabe.gamerepository.di.modules.PresenterModule;
import com.dabe.gamerepository.di.modules.ViewModule;
import com.dabe.gamerepository.model.DataManager;
import com.dabe.gamerepository.presenter.presenters.AddGamePresenter;
import com.dabe.gamerepository.presenter.presenters.MainPresenter;
import com.dabe.gamerepository.view.ui.activities.MainActivity;
import com.dabe.gamerepository.view.ui.fragments.AddGameFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Daniil Belevtsev on 12.01.2017 0:26.
 * Project: GameRepository; Skype: pandamoni1
 */

@Singleton
@Component(modules = {AppModule.class, ModelModule.class, ViewModule.class, PresenterModule.class})
public interface BaseComponent {

    ///////////////////////////////////////////////////////////////////////////
    // MODEL
    ///////////////////////////////////////////////////////////////////////////
    void inject(DataManager dataManager);

    ///////////////////////////////////////////////////////////////////////////
    // VIEW
    ///////////////////////////////////////////////////////////////////////////
    void inject(MainActivity activity);
    void inject(AddGameFragment fragment);

    ///////////////////////////////////////////////////////////////////////////
    // PRESENTER
    ///////////////////////////////////////////////////////////////////////////
    void inject(MainPresenter presenter);
    void inject(AddGamePresenter presenter);
}
