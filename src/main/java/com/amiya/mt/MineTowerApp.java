package com.amiya.mt;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.SceneFactory;
import com.almasb.fxgl.dsl.FXGL;
import com.amiya.mt.ui.scene.MineTowerMainMenu;
import org.jetbrains.annotations.NotNull;

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
    }

    public static void main(String[] args) {
        launch(args);
    }
}
