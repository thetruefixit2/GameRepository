package com.dabe.gamerepository.view.ui.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dabe.gamerepository.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniil Belevtsev on 14.12.2016 0:24.
 * Project: GameRepository; Skype: pandamoni1
 */

public class LoadingView extends RelativeLayout {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.loadingText)
    TextView loadingText;

    public LoadingView(Context context) {
        super(context);
        init();
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        View rootView = inflate(getContext(), R.layout.view_loading, this);
        ButterKnife.bind(this, rootView);
    }

    public void setLoadingText(String message) {
        if (loadingText != null && message != null) {
            loadingText.setText(message);
        }
    }

    public void setErrorText(@StringRes int message) {
        if (loadingText != null && message != -1) {
            loadingText.setText(message);
        }
    }
}
