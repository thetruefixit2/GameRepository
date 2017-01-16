package com.dabe.gamerepository.view.ui.activities;

import android.os.Bundle;

import com.andrognito.pinlockview.PinLockListener;
import com.andrognito.pinlockview.PinLockView;
import com.dabe.gamerepository.R;

import butterknife.BindView;

/**
 * Created by Daniil Belevtsev on 17.01.2017 0:32.
 * Project: GameRepository; Skype: pandamoni1
 */

public class LockActivity extends RouteActivity implements PinLockListener {

    @BindView(R.id.pin_lock_view)
    PinLockView lockView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lockView.setPinLockListener(this);
    }

    @Override
    public void onComplete(String pin) {
        System.out.println(pin);
    }

    @Override
    public void onEmpty() {
        System.out.println("EMPTY");
    }

    @Override
    public void onPinChange(int pinLength, String intermediatePin) {
        System.out.println(intermediatePin);
    }
}
