package com.dabe.gamerepository.model;

import android.content.Context;

import com.dabe.gamerepository.R;
import com.dabe.gamerepository.app.AppConsts;
import com.dabe.gamerepository.app.TheApp;
import com.dabe.gamerepository.model.api.IGDBApi;
import com.dabe.gamerepository.model.api.ISteamApi;
import com.dabe.gamerepository.model.data.bo.GameBO;
import com.dabe.gamerepository.model.data.enums.DataProvideEnum;
import com.dabe.gamerepository.utils.IGProviderSetter;
import com.dabe.gamerepository.utils.SteamProviderSetter;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;


/**
 * Created by Daniil Belevtsev on 12.01.2017 0:34.
 * Project: GameRepository; Skype: pandamoni1
 */

public class DataManager implements IDataManager {

    private final Observable.Transformer shedulersTransformer;

    @Inject
    protected Context context;

    @Inject
    protected ISteamApi steamApi;

    @Inject
    protected IGDBApi igdbApi;

    @Inject
    @Named(AppConsts.UI_THREAD)
    protected Scheduler uiThread;

    @Inject
    @Named(AppConsts.IO_THREAD)
    protected Scheduler ioThread;


    public DataManager() {
        TheApp.getComponent().inject(this);
        shedulersTransformer = observable -> ((Observable) observable).subscribeOn(ioThread)
                .observeOn(uiThread)
                .unsubscribeOn(ioThread);
    }

    @Override
    public Observable<List<GameBO>> getGameList(Map<String, String> parameters, DataProvideEnum provider) {
        switch (provider) {
            case IGDB:
                return igdbApi.getGameByName(parameters)
                        .flatMap(Observable::from)
                        .map(new IGProviderSetter(provider))
                        .map(GameBO::new)
                        .toList()
                        .compose(applyShedulers());
            case STEAM:
                return igdbApi.getGameByName(parameters)
                        .flatMap(Observable::from)
                        .map(new IGProviderSetter(provider))
                        .map(GameBO::new)
                        .toList()
                        .compose(applyShedulers());
        }
        return null;
    }

    @Override
    public Observable<List<GameBO>> getUserGameList(Map<String, String> parameters, DataProvideEnum provider) {
        return steamApi.getUserGameList(getApiKey(provider), parameters)
                .flatMap(response -> Observable.from(response.getGamesList().getGames()))
                .map(new SteamProviderSetter(provider))
                .map(GameBO::new)
                .toList()
                .compose(applyShedulers());
    }

    @SuppressWarnings("unchecked")
    private <T> Observable.Transformer<T, T> applyShedulers() {
        return (Observable.Transformer<T, T>) shedulersTransformer;
    }

    private String getApiKey(DataProvideEnum provider) {
        switch (provider) {
            case IGDB:
                return context.getString(R.string.igdb_key);
            case STEAM:
                return context.getString(R.string.steam_key);
            default:
                return null;
        }
    }
}
