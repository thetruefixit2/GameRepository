package com.dabe.gamerepository.model.data.dto;

import com.dabe.gamerepository.model.data.enums.DataProvideEnum;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Daniil Belevtsev on 12.01.2017 0:33.
 * Project: GameRepository; Skype: pandamoni1
 */

public class Game {
    public static final String TYPE = "GAME";

    @SerializedName("name")
    private String name;

    @Expose
    private DataProvideEnum dataProvider;

    public Game(String name, DataProvideEnum dataProvider) {
        this.name = name;
        this.dataProvider = dataProvider;
    }

    public String getName() {
        return name;
    }

    public DataProvideEnum getDataProvider() {
        return dataProvider;
    }

    public void setDataProvider(DataProvideEnum dataProvider) {
        this.dataProvider = dataProvider;
    }
}