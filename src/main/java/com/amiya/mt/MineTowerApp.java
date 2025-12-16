package com.amiya.mt;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.SceneFactory;
import com.almasb.fxgl.core.EngineService;
import com.almasb.fxgl.core.collection.PropertyMap;
import com.almasb.fxgl.dsl.FXGL;
import com.amiya.mt.ui.scene.ChooseStartPrize;
import com.amiya.mt.ui.scene.MineTowerMainMenu;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class MineTowerApp extends GameApplication{


    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setTitle("MineTower");
        gameSettings.setWidth(1080);
        gameSettings.setHeight(720);
        gameSettings.setMainMenuEnabled(true);
        gameSettings.setSceneFactory(new SceneFactory(){
            @NotNull
            @Override
            public FXGLMenu newMainMenu(){
                return new MineTowerMainMenu();
            }
        });

        //注册所有框架提供的引擎服务
        gameSettings.addEngineService(GameEngineService.class);
    }

    @Override
    protected void initGameVars(Map<String,Object> vars){
        vars.put("character",CharactersLIst.NULL);
    }

    @Override
    protected void initGame() {
        FXGL.entityBuilder()
                .at(150, 150)
                .view(new Rectangle(40, 40, Color.BLUE))
                .buildAndAttach();

        System.out.println("Entities in world: " + FXGL.getGameWorld().getEntities().size());
    }




    public static void main(String[] args) {
        launch(args);
    }
}
