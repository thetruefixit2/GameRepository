package com.dabe.gamerepository.model.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Daniil Belevtsev on 15.01.2017 16:13.
 * Project: GameRepository; Skype: pandamoni1
 */

public class GamesList {

    @SerializedName("games")
    @Expose
    private List<SteamGame> games;

    public GamesList(List<SteamGame> games) {
        this.games = games;
    }

    public List<SteamGame> getGames() {
        return games;
    }
}
