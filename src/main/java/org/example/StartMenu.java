package org.example;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.GameScene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameScene;


public class StartMenu extends GameApplication{
    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setTitle("MineTower");
        gameSettings.setWidth(1080);
        gameSettings.setHeight(720);
    }

    @Override
    protected void initUI(){
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/ui/StartMenu.fxml"));
            Parent startMenuRoot=loader.load();

            GameScene startMenu = getGameScene();
            startMenu.getRoot().getChildren().add(startMenuRoot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}