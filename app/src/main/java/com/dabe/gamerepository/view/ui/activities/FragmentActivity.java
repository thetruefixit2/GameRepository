package com.dabe.gamerepository.view.ui.activities;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Daniil Belevtsev on 12.01.2017 0:36.
 * Project: GameRepository; Skype: pandamoni1
 * <p>
 * Activity that
 */

public class FragmentActivity extends AppCompatActivity {

    private int container;

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = super.onCreateView(name, context, attrs);
        ButterKnife.bind(view, this);
        return view;
    }

    protected void replaceFragment(Fragment fragment, boolean isAddBackstack) {

    }

    protected void replaceFragment(@IdRes int container, Fragment fragment, boolean isAddBackstack) {

    }

    protected void addFragment(Fragment fragment, boolean isAddBackstack) {

    }

    protected <T extends Fragment> Fragment findAddedFragment(Class<T> clazz) {
        return null;
    }

}
