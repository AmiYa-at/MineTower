package com.amiya.mt.ui.scene;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.scene.SubScene;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;


public class ChooseCharactersMenu extends SubScene {

    private int choose;

    public ChooseCharactersMenu() {
        //设置背景
        var background=new Pane();
        background.setPrefSize(FXGL.getAppWidth(),FXGL.getAppHeight());
        background.setStyle("-fx-background-color: #333;");

        /*
        * 设置页面底下左右两边分别为返回键和启程键
        * */
        //设置底下容器
        var backAndContinueBox=new HBox(20);
        backAndContinueBox.setPrefSize(FXGL.getAppWidth(),70);

        //设置左侧返回按钮
        var backButton = new MenuButton("back.png",70,()-> FXGL.getSceneService().popSubScene());

        //设置填充节点
        var spacer=new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        //设置右侧启程按钮

        //添加到HBox
        backAndContinueBox.getChildren().addAll(backButton,spacer);
        backButton.setTranslateX(20);
        backAndContinueBox.setAlignment(Pos.CENTER);
        backAndContinueBox.setLayoutY(500);





        getContentRoot().getChildren().addAll(background,backAndContinueBox);
    }
}
