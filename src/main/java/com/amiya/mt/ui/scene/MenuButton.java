package com.amiya.mt.ui.scene;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;
import javafx.beans.binding.Bindings;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class MenuButton extends StackPane {

    //按钮状态材质变量，包含默认状态、鼠标悬停状态和点击状态
    Texture defaultButtonState;
    Texture hoveredButtonState;
    Texture clickedButtonState;

    //按钮本体
    Texture button;
    Text label;

    public MenuButton(String text, double width,double height, Runnable action,String defaultState, String hoveredState, String clickedState){
        //按钮材质预先加载
        defaultButtonState=FXGL.texture(defaultState);
        hoveredButtonState=FXGL.texture(hoveredState);
        clickedButtonState=FXGL.texture(clickedState);

        //按钮材质设置默认状态
        button=FXGL.texture(defaultState);
        button.setFitWidth(width);
        button.setFitHeight(height);
        button.setPickOnBounds(false);

        //按钮上的文字初始化
        label=FXGL.getUIFactoryService().newText(text);

        //为按键样式变化绑定事件
        var buttonStyleChange=Bindings.when(pressedProperty()).then(clickedButtonState.getImage()).otherwise(
                Bindings.when(hoverProperty()).then(hoveredButtonState.getImage()).otherwise(defaultButtonState.getImage()));
        button.imageProperty().bind(buttonStyleChange);

        //注册点击事件
        setOnMouseClicked(e->action.run());

        //将按钮容器加入到UI节点
        getChildren().addAll(button,label);
    }
}
