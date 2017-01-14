package com.dabe.gamerepository.app;

import android.app.Application;

import com.dabe.gamerepository.di.components.BaseComponent;
import com.dabe.gamerepository.di.components.DaggerBaseComponent;
import com.dabe.gamerepository.di.modules.AppModule;
import com.dabe.gamerepository.di.modules.ModelModule;
import com.dabe.gamerepository.di.modules.PresenterModule;
import com.dabe.gamerepository.di.modules.ViewModule;

/**
 * Created by Daniil Belevtsev on 12.01.2017 0:25.
 * Project: GameRepository; Skype: pandamoni1
 * <p>
 * The app file, gives component for dagger.
 */

public class TheApp extends Application {
    private static BaseComponent component;

    public static BaseComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }

    /**
     * Build dagger2 component
     */
    private BaseComponent buildComponent() {
        return DaggerBaseComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .modelModule(new ModelModule())
                .presenterModule(new PresenterModule())
                .viewModule(new ViewModule())
                .build();
    }
}
