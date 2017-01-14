package com.dabe.gamerepository.view.interfaces;

import com.dabe.gamerepository.model.data.bo.GameBO;
import com.dabe.gamerepository.view.base.IBaseView;

import java.util.List;

/**
 * Created by Daniil Belevtsev on 14.01.2017 3:18.
 * Project: GameRepository; Skype: pandamoni1
 */

public interface IAddGameView extends IBaseView {
    void onGamesLoaded(List<GameBO> gamesList);
}
