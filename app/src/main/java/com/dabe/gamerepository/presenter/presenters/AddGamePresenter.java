package com.dabe.gamerepository.presenter.presenters;

import com.dabe.gamerepository.app.TheApp;
import com.dabe.gamerepository.model.data.bo.GameBO;
import com.dabe.gamerepository.model.data.enums.DataProvideEnum;
import com.dabe.gamerepository.model.data.finals.IGConsts;
import com.dabe.gamerepository.presenter.base.BasePresenter;
import com.dabe.gamerepository.utils.IGRequestBuilder;
import com.dabe.gamerepository.utils.SteamRequest;
import com.dabe.gamerepository.view.interfaces.IAddGameView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Daniil Belevtsev on 14.01.2017 3:18.
 * Project: GameRepository; Skype: pandamoni1
 */

public class AddGamePresenter extends BasePresenter<IAddGameView> {

    public void init(IAddGameView view) {
        TheApp.getComponent().inject(this);
        setView(view);
    }

    public void findGame(String gameName, DataProvideEnum provider) {
        Map<String, String> params = null;
        Subscription sub;
        switch (provider) {
            case IGDB:
                IGRequestBuilder builder = new IGRequestBuilder.Builder()
                        .addField(IGConsts.ID_FIELD)
                        .addField(IGConsts.NAME_FIELD)
                        .addField(IGConsts.SUMMARY_FIELD)
                        .addField(IGConsts.COVER_FIELD)
                        .limit(10)
                        .offset(0)
                        .gameName(gameName)
                        .build();
                params = builder.getRequestParams();
                break;
            case STEAM:
                // TODO: 14.01.2017 need builder
                params = new HashMap<>();
                break;
        }
        sub = dataManager.getGameList(params, provider)
                .subscribe(new Subscriber<List<GameBO>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<GameBO> gamesList) {
                        getView().onGamesLoaded(gamesList);
                    }
                });

        addSubscriber(sub);
    }

    public void loadUserGame(String steamID) {
        SteamRequest builder = new SteamRequest.Builder()
                .steamid(steamID)
                .build();
        Subscription sub = dataManager
                .getUserGameList(builder.getParams(), DataProvideEnum.STEAM)
                .subscribe(new Subscriber<List<GameBO>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<GameBO> gamesList) {
                        getView().onGamesLoaded(gamesList);
                    }
                });
    }
}
