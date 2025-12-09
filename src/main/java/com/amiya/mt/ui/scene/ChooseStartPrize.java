package com.amiya.mt.ui.scene;

import com.almasb.fxgl.app.scene.FXGLScene;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.scene.SubScene;
import javafx.scene.layout.Pane;

public class ChooseStartPrize extends SubScene {

    public ChooseStartPrize(){
        //设置按钮效果
        var background=new Pane();
        background.setPrefSize(FXGL.getAppWidth(),FXGL.getAppHeight());
        background.setStyle("-fx-background-color: #333;");

        getContentRoot().getChildren().addAll(background);
    }
}
