package com.dabe.gamerepository.di.modules;

import com.dabe.gamerepository.app.AppConsts;
import com.dabe.gamerepository.model.api.IGDBApi;
import com.dabe.gamerepository.model.api.ISteamApi;
import com.dabe.gamerepository.utils.IGApiInterceptor;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
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
    IGDBApi provideIGDBApi() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new IGApiInterceptor())
                .build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(AppConsts.IGDB_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        builder.client(client);

        return builder.build().create(IGDBApi.class);
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
