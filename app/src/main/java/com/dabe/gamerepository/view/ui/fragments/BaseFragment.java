package com.dabe.gamerepository.view.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Daniil Belevtsev on 12.01.2017 0:53.
 * Project: GameRepository; Skype: pandamoni1
 */

public abstract class BaseFragment extends Fragment {

    /**
     * Retrieved bundle asap on onCreate
     */
    public abstract void onInitBundle();

    /**
     * init default state when view is created
     */
    public abstract void onInitDefaultData();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        onInitBundle();
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        onInitDefaultData();
        super.onViewCreated(view, savedInstanceState);
    }

}
