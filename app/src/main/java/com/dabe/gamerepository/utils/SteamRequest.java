package com.dabe.gamerepository.utils;

import com.dabe.gamerepository.model.data.finals.SteamConsts;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daniil Belevtsev on 15.01.2017 16:28.
 * Project: GameRepository; Skype: pandamoni1
 */

public class SteamRequest {
    private String steamid;
    private Map<String, String> params;

    public Map<String, String> getParams() {
        return params;
    }

    public SteamRequest(String steamid) {
        this.steamid = steamid;
    }

    private SteamRequest(Builder builder) {
        steamid = builder.steamid;
        params = builder.params;
    }


    public static final class Builder {
        private String steamid;
        private Map<String, String> params;

        public Builder() {
        }

        public Builder steamid(String val) {
            steamid = val;
            return this;
        }

        public SteamRequest build() {
            params = new HashMap<>();
            params.put(SteamConsts.APPINFO_FIELD, "1");
            params.put(SteamConsts.FREE_GAMES_FIELD, "0");
            params.put(SteamConsts.FORMAT_FIELD, "json");
            params.put(SteamConsts.STEAM_ID_FIELD, steamid);
            return new SteamRequest(this);
        }
    }
}
