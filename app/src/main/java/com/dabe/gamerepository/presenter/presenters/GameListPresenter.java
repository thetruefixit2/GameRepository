package com.dabe.gamerepository.presenter.presenters;

import com.dabe.gamerepository.app.TheApp;
import com.dabe.gamerepository.presenter.base.BasePresenter;
import com.dabe.gamerepository.view.interfaces.IGameListView;

/**
 * Created by Daniil Belevtsev on 14.01.2017 3:18.
 * Project: GameRepository; Skype: pandamoni1
 */

public class GameListPresenter extends BasePresenter<IGameListView> {

    public void init(IGameListView view) {
        TheApp.getComponent().inject(this);
        setView(view);
    }

}
