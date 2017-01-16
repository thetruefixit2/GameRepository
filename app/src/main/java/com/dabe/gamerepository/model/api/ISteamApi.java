package com.dabe.gamerepository.model.api;

import com.dabe.gamerepository.model.data.dto.Response;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Daniil Belevtsev on 14.01.2017 4:24.
 * Project: GameRepository; Skype: pandamoni1
 */

public interface ISteamApi {

    @GET("/IPlayerService/GetOwnedGames/v0001/")
    Observable<Response> getUserGameList(@Query("key") String apiKey, @QueryMap Map<String, String> params);

}
