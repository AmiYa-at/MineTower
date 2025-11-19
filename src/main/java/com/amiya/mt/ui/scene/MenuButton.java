package com.amiya.mt.ui.scene;

import com.almasb.fxgl.dsl.FXGL;
import javafx.beans.binding.Bindings;
import javafx.scene.Parent;

public class MenuButton extends Parent {
    public MenuButton(String name, double width, Runnable action){
        var btn= FXGL.texture(name);
        btn.setPreserveRatio(true);
        btn.setFitWidth(width);
        btn.setPickOnBounds(false);

        //为按键样式变化绑定事件
        var buttonScaleChange=Bindings.when(pressedProperty()).then(0.87).otherwise(
                Bindings.when(hoverProperty()).then(0.99).otherwise(1.0));
        btn.scaleXProperty().bind(buttonScaleChange);
        btn.scaleYProperty().bind(buttonScaleChange);

        //注册点击事件
        setOnMouseClicked(e->action.run());

        //将按钮容器加入到UI节点
        getChildren().add(btn);
    }
}
