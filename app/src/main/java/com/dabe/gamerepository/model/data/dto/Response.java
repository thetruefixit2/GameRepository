package com.dabe.gamerepository.model.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Daniil Belevtsev on 17.01.2017 0:09.
 * Project: GameRepository; Skype: pandamoni1
 */

public class Response {

    @Expose
    @SerializedName("response")
    private GamesList gemesList;

    public GamesList getGamesList() {
        return gemesList;
    }
}
