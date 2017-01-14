package com.dabe.gamerepository.view.ui.activities;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Daniil Belevtsev on 12.01.2017 0:36.
 * Project: GameRepository; Skype: pandamoni1
 * <p>
 * Activity that
 */

public class FragmentActivity extends AppCompatActivity {

    private int container;

    protected void replaceFragment(Fragment fragment, boolean isAddBackstack) {
        String tag = fragment.getClass().getSimpleName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(container, fragment, tag);
        if (isAddBackstack) {
            transaction.addToBackStack(tag);
        }
        transaction.commitAllowingStateLoss();
    }

    protected void replaceFragment(@IdRes int customContainer, Fragment fragment, boolean isAddBackstack) {
        String tag = fragment.getClass().getSimpleName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(customContainer, fragment, tag);
        if (isAddBackstack) {
            transaction.addToBackStack(tag);
        }
        transaction.commitAllowingStateLoss();
    }

    protected void addFragment(Fragment fragment, boolean isAddBackstack) {
        String tag = fragment.getClass().getSimpleName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(container, fragment, tag);
        if (isAddBackstack) {
            transaction.addToBackStack(tag);
        }
        transaction.commitAllowingStateLoss();
    }

    protected <T extends Fragment> Fragment findAddedFragment(Class<T> clazz) {
        return null;
    }

    /**
     * Container setter for fragment control.
     * All activities should set container in onCreate
     *
     * @param container
     */
    public void setContainer(int container) {
        this.container = container;
    }
}
