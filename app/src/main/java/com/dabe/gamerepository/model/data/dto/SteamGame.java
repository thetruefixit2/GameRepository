package com.dabe.gamerepository.model.data.dto;

import com.dabe.gamerepository.model.data.enums.DataProvideEnum;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Daniil Belevtsev on 14.01.2017 16:47.
 * Project: GameRepository; Skype: pandamoni1
 */

public class SteamGame extends Game {

    @SerializedName("appid")
    private int id;

    public SteamGame(int id, String name) {
        super(name, DataProvideEnum.STEAM);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
