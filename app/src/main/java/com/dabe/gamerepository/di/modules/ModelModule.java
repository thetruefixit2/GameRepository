package com.dabe.gamerepository.di.modules;

import com.dabe.gamerepository.app.AppConsts;
import com.dabe.gamerepository.model.api.IGamesDBApi;
import com.dabe.gamerepository.model.api.ISteamApi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Daniil Belevtsev on 12.01.2017 0:27.
 * Project: GameRepository; Skype: pandamoni1
 */
@Module
public class ModelModule {
    @Provides
    @Singleton
    ISteamApi provideSteamApi() {
        OkHttpClient client = new OkHttpClient();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(AppConsts.STEAM_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        builder.client(client);
        return builder.build().create(ISteamApi.class);
    }

    @Provides
    @Singleton
    IGamesDBApi provideGamesDBApi() {
        OkHttpClient client = new OkHttpClient();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(AppConsts.STEAM_BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        builder.client(client);
        return builder.build().create(IGamesDBApi.class);
    }

    @Provides
    @Singleton
    @Named(AppConsts.UI_THREAD)
    Scheduler provideSchedulerUI() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    @Named(AppConsts.IO_THREAD)
    Scheduler provideSchedulerIO() {
        return Schedulers.io();
    }


}
