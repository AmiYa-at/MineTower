package com.amiya.mt.ui.scene;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.scene.SubScene;
import com.amiya.mt.CharactersLIst;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

import java.util.ArrayList;


public class ChooseCharactersMenu extends SubScene {

    private CharactersLIst choose;
    ArrayList<MenuButton> characterButtonsList=new ArrayList<>();

    public ChooseCharactersMenu() {
        //设置背景
        var background=new Pane();
        background.setPrefSize(FXGL.getAppWidth(),FXGL.getAppHeight());
        background.setStyle("-fx-background-color: #333;");

        /*
         * 设置页面底下左右两边分别为返回键和启程键
         * */
        //设置底下返回&启程按钮容器
        var backAndContinueBox=new HBox(10);
        backAndContinueBox.setPrefSize(FXGL.getAppWidth()-50,70);

        //设置左侧返回按钮
        var backButton = new MenuButton("返回",100,40,()-> FXGL.getSceneService().popSubScene(),"button.png","button_highlighted.png","button_disabled.png",true);

        //设置填充节点
        var spacer=new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        //设置右侧启程按钮
        var startButton=new MenuButton("启程",100,40,()->{
            FXGL.getGameController().startNewGame();
            FXGL.set("character",choose);},"button.png","button_highlighted.png","button_disabled.png",true);
        startButton.setVisible(false);

        //添加到HBox
        backAndContinueBox.getChildren().addAll(backButton,spacer,startButton);
        backButton.setTranslateX(20);
        backAndContinueBox.setAlignment(Pos.CENTER);
        backAndContinueBox.setLayoutY(500);

        /*
        * 设置页面中下方一排为选择角色的按钮
         */
        //设置角色按钮的容器
        var charactersButtonBox=new HBox(20);
        charactersButtonBox.setPrefSize(FXGL.getAppWidth(),50);

        //逐个实例化角色对应的按钮
        for(CharactersLIst character:CharactersLIst.values()){
            if(character!=CharactersLIst.NULL){
                characterButtonsList.add(new MenuButton("",50,50,
                        ()->{
                            choose=character;
                            BackgroundImage backgroundImage=new BackgroundImage(
                                    FXGL.image(character.getCharactersData().getBackgroundPath()),
                                    BackgroundRepeat.NO_REPEAT,
                                    BackgroundRepeat.NO_REPEAT,
                                    BackgroundPosition.CENTER,
                                    new BackgroundSize(
                                            BackgroundSize.AUTO,
                                            BackgroundSize.AUTO,
                                            true,
                                            true,
                                            true,
                                            false
                                    ));
                            Background bg=new Background(backgroundImage);
                            background.setBackground(bg);
                            startButton.setVisible(true);
                        },character.getCharactersData().getNamePath(),character.getCharactersData().getNamePath(),character.getCharactersData().getNamePath(),false));
            }

        }

        //将角色按钮添加到HBox
        for(MenuButton button:characterButtonsList){
            charactersButtonBox.getChildren().addAll(button);
        }
        charactersButtonBox.setAlignment(Pos.CENTER);
        charactersButtonBox.setLayoutY(400);








        getContentRoot().getChildren().addAll(background,backAndContinueBox,charactersButtonBox);
    }
}
