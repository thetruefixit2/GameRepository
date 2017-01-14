package com.dabe.gamerepository.view.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.dabe.gamerepository.R;
import com.dabe.gamerepository.app.TheApp;
import com.dabe.gamerepository.model.data.bo.GameBO;
import com.dabe.gamerepository.model.data.enums.DataProvideEnum;
import com.dabe.gamerepository.presenter.presenters.AddGamePresenter;
import com.dabe.gamerepository.view.interfaces.IAddGameView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Daniil Belevtsev on 12.01.2017 1:33.
 * Project: GameRepository; Skype: pandamoni1
 */

public class AddGameFragment extends BaseFragment implements IAddGameView {

    @Inject
    AddGamePresenter presenter;
    @BindView(R.id.etGameName)
    EditText etGameName;
    @BindView(R.id.gameList)
    RecyclerView rvGameList;
    @BindView(R.id.btnNext)
    Button btnNext;

    public static AddGameFragment newInstance() {
        Bundle args = new Bundle();
        AddGameFragment fragment = new AddGameFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        TheApp.getComponent().inject(this);
        super.onCreate(savedInstanceState);
        presenter.init(this);
    }

    @Override
    public void onInitBundle() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onInitDefaultData() {

    }

    @OnClick(R.id.btnNext)
    public void onClick() {
        loadData(etGameName.getText().toString());
    }

    public void loadData(String gameName) {
        presenter.loadData(gameName, DataProvideEnum.IGDB);
    }

    ///////////////////////////////////////////////////////////////////////////
    // CALLBACK ZONE
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void showError(String errorMessage) {

    }

    @Override
    public void showLoading(String loadingMessage) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onGamesLoaded(List<GameBO> gamesList) {

    }
}
