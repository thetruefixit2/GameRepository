package com.dabe.gamerepository.model;

import com.dabe.gamerepository.model.data.bo.GameBO;
import com.dabe.gamerepository.model.data.enums.DataProvideEnum;

import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * Created by Daniil Belevtsev on 12.01.2017 0:34.
 * Project: GameRepository; Skype: pandamoni1
 */

public interface IDataManager {
    Observable<List<GameBO>> getGameList(Map<String, String> parameters, DataProvideEnum provider);
    Observable<List<GameBO>> getUserGameList(Map<String, String> parameters, DataProvideEnum provider);
}
