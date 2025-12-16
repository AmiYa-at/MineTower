package com.amiya.mt;

import com.almasb.fxgl.core.EngineService;
import com.almasb.fxgl.core.collection.PropertyMap;
import com.almasb.fxgl.dsl.FXGL;
import com.amiya.mt.ui.scene.ChooseStartPrize;
import javafx.application.Platform;
import org.jetbrains.annotations.NotNull;

public class GameEngineService extends EngineService {

    //游戏开始时设置
    @Override
    public void onGameReady(@NotNull PropertyMap vars) {
        System.out.println("GameEngineService.onGameReady() called");
        Platform.runLater(()-> {
            FXGL.getSceneService().pushSubScene(new ChooseStartPrize());
        System.out.println("开始");});
    }
}

