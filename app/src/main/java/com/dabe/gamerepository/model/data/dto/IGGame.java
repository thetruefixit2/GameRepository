package com.dabe.gamerepository.model.data.dto;

import com.dabe.gamerepository.model.data.enums.DataProvideEnum;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Daniil Belevtsev on 14.01.2017 16:47.
 * Project: GameRepository; Skype: pandamoni1
 */

public class IGGame extends Game {

    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("summary")
    private String summary;

    @SerializedName("first_release_date")
    private long firstReleaseDate;
    @Expose

    @SerializedName("cover")
    private Cover cover;

    public IGGame(String name, int id, String summary, long firstReleaseDate, Cover cover) {
        super(name, DataProvideEnum.IGDB);
        this.id = id;
        this.summary = summary;
        this.firstReleaseDate = firstReleaseDate;
        this.cover = cover;
    }

    public int getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public long getFirstReleaseDate() {
        return firstReleaseDate;
    }

    public Cover getCover() {
        return cover;
    }


}
