package com.dabe.gamerepository.view.ui.activities;


import android.os.Bundle;

import com.dabe.gamerepository.R;
import com.dabe.gamerepository.app.TheApp;
import com.dabe.gamerepository.presenter.presenters.MainPresenter;
import com.dabe.gamerepository.view.interfaces.IMainView;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends LockActivity implements IMainView {

    @Inject
    MainPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        TheApp.getComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
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
