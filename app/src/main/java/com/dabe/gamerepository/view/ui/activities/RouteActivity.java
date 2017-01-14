package com.dabe.gamerepository.view.ui.activities;

import com.dabe.gamerepository.view.ui.fragments.GameListFragment;

/**
 * Created by Daniil Belevtsev on 12.01.2017 0:37.
 * Project: GameRepository; Skype: pandamoni1
 * <p>
 * Activity that control transactions between screens(fragment switching)
 */

public class RouteActivity extends FragmentActivity {

    protected void showGameListFragment() {
        replaceFragment(GameListFragment.newInstance(), false);
    }

}
