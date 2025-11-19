package com.amiya.mt.ui.scene;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import com.almasb.fxgl.dsl.FXGL;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.NotNull;

public class MineTowerMainMenu extends FXGLMenu {


    public MineTowerMainMenu() {
        super(MenuType.MAIN_MENU);

        //标题图片加载
        var StartTitle= FXGL.texture("title.png");
        StartTitle.setPreserveRatio(true);
        StartTitle.setFitWidth(500);
        var menuBox=new VBox(30,StartTitle,
                new MenuButton("start.png",300,()->FXGL.getSceneService().pushSubScene(new ChooseCharactersMenu())));
        menuBox.setAlignment(Pos.CENTER);
        menuBox.setPrefSize(getAppWidth(),getAppHeight());
        menuBox.setStyle("-fx-background-color: #333;");
        StartTitle.setTranslateY(-100);

        getContentRoot().getChildren().addAll(menuBox);
    }
}
