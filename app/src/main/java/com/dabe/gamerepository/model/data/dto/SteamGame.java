package com.dabe.gamerepository.model.data.dto;

import com.dabe.gamerepository.model.data.enums.DataProvideEnum;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Daniil Belevtsev on 14.01.2017 16:47.
 * Project: GameRepository; Skype: pandamoni1
 */

public class SteamGame extends Game {

    @SerializedName("appid")
    @Expose
    private int id;
    @SerializedName("playtime_forever")
    @Expose
    private int playtimeForever;
    @SerializedName("img_icon_url")
    @Expose
    private String imgIconUrl;
    @SerializedName("img_logo_url")
    @Expose
    private String imgLogoUrl;
    @SerializedName("has_community_visible_stats")
    @Expose
    private boolean hasCommunityVisibleStats;

    public SteamGame(int id, String name,int playtimeForever, String imgIconUrl, String imgLogoUrl, boolean hasCommunityVisibleStats) {
        super(name, DataProvideEnum.STEAM);
        this.id = id;
        this.playtimeForever = playtimeForever;
        this.imgIconUrl = imgIconUrl;
        this.imgLogoUrl = imgLogoUrl;
        this.hasCommunityVisibleStats = hasCommunityVisibleStats;
    }

    public int getId() {
        return id;
    }

    public int getPlaytimeForever() {
        return playtimeForever;
    }

    public String getImgIconUrl() {
        return imgIconUrl;
    }

    public String getImgLogoUrl() {
        return imgLogoUrl;
    }

    public boolean isHasCommunityVisibleStats() {
        return hasCommunityVisibleStats;
    }
}
