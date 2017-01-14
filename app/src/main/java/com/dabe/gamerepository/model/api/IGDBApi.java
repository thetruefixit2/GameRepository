package com.dabe.gamerepository.model.api;

import com.dabe.gamerepository.model.data.dto.IGGame;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Daniil Belevtsev on 14.01.2017 5:10.
 * Project: GameRepository; Skype: pandamoni1
 */

public interface IGDBApi {
    @GET("/games/")
    Observable<ArrayList<IGGame>> getGameByName(@QueryMap Map<String, String> params);
}
