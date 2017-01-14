package com.dabe.gamerepository.view.ui.activities;


import android.os.Bundle;

import com.dabe.gamerepository.R;
import com.dabe.gamerepository.app.TheApp;
import com.dabe.gamerepository.presenter.presenters.MainPresenter;
import com.dabe.gamerepository.view.interfaces.IMainView;

import javax.inject.Inject;

public class MainActivity extends RouteActivity implements IMainView {

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TheApp.getComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContainer(R.id.container);
        presenter.init(this);
        initUI();
    }

    public void initUI() {
        showGameListFragment();
    }

    @Override
    public void showError(String errorMessage) {

    }

    @Override
    public void showLoading(String loadingMessage) {

    }

    @Override
    public void hideLoading() {

    }
}
