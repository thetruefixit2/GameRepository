package com.dabe.gamerepository.view.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dabe.gamerepository.R;
import com.dabe.gamerepository.presenter.presenters.GameListPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Daniil Belevtsev on 12.01.2017 1:33.
 * Project: GameRepository; Skype: pandamoni1
 */

public class GameListFragment extends BaseFragment {

    @Inject
    GameListPresenter presenter;

    public static GameListFragment newInstance() {
        Bundle args = new Bundle();
        GameListFragment fragment = new GameListFragment();
        fragment.setArguments(args);
        return fragment;
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

}
