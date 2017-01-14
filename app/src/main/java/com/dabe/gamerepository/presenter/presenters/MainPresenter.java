package com.dabe.gamerepository.presenter.presenters;

import com.dabe.gamerepository.app.TheApp;
import com.dabe.gamerepository.presenter.base.BasePresenter;
import com.dabe.gamerepository.view.interfaces.IMainView;

/**
 * Created by Daniil Belevtsev on 12.01.2017 1:38.
 * Project: GameRepository; Skype: pandamoni1
 */

public class MainPresenter extends BasePresenter<IMainView> {

    public void init(IMainView view) {
        TheApp.getComponent().inject(this);
        setView(view);
    }
}
