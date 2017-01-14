package com.dabe.gamerepository.model.data.bo;

import com.dabe.gamerepository.model.data.dto.IGGame;
import com.dabe.gamerepository.model.data.dto.SteamGame;
import com.dabe.gamerepository.model.data.enums.DataProvideEnum;

/**
 * Created by Daniil Belevtsev on 14.01.2017 19:11.
 * Project: GameRepository; Skype: pandamoni1
 *  BO = business object, only for views
 */

public class GameBO {
    private int gameId;
    private String gameName;
    private String gameInfo;
    private String screenURL;
    private DataProvideEnum provider;

    public GameBO(int gameId, String gameName, String gameInfo, String screenURL, DataProvideEnum provider) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.gameInfo = gameInfo;
        this.screenURL = screenURL;
        this.provider = provider;
    }

    public GameBO(IGGame igGame) {
        this.gameId = igGame.getId();
        this.gameName = igGame.getName();
        this.gameInfo = igGame.getSummary();
        this.screenURL = igGame.getCover().getUrl();
        this.provider = DataProvideEnum.IGDB;
    }

    public GameBO(SteamGame steamGame) {
        this.gameId = steamGame.getId();
        this.gameName = steamGame.getName();
        this.provider = DataProvideEnum.STEAM;
    }

    public int getGameId() {
        return gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public String getGameInfo() {
        return gameInfo;
    }

    public String getScreenURL() {
        return screenURL;
    }

    public DataProvideEnum getProvider() {
        return provider;
    }
}
