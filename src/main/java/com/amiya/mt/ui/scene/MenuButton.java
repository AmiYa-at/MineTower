package com.amiya.mt.ui.scene;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.NineSliceTextureBuilder;
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

    public MenuButton(String text, int width,int height, Runnable action,String defaultState, String hoveredState, String clickedState, boolean isButton){
        //按钮材质预先加载
        defaultButtonState=FXGL.texture(defaultState);
        hoveredButtonState=FXGL.texture(hoveredState);
        clickedButtonState=FXGL.texture(clickedState);

        //如果按钮是UI按钮（需要保持伸缩一致性），则将其转换为9宫格材质
        if(isButton){
            defaultButtonState=createNineSliceTexture(defaultButtonState,width,height);
            hoveredButtonState=createNineSliceTexture(hoveredButtonState,width,height);
            clickedButtonState=createNineSliceTexture(clickedButtonState,width,height);
        }

        //按钮材质设置默认状态
        button=defaultButtonState;
        if(!isButton){
            button.setFitWidth(width);
            button.setFitHeight(height);
        }
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

    public Texture createNineSliceTexture(Texture sourceTexture,int targetWidth,int targetHeight){
        long cornerWidth=Math.round(sourceTexture.getWidth()*0.2);
        long cornerHeight=Math.round(sourceTexture.getHeight()*0.2);
        long centerWidth=Math.round(sourceTexture.getWidth())-2*cornerWidth;
        long centerHeight=Math.round(sourceTexture.getHeight())-2*cornerHeight;
        NineSliceTextureBuilder builder=new NineSliceTextureBuilder(sourceTexture)
                .topLeft(0,0,cornerWidth,cornerHeight)
                .top(cornerWidth,0,centerWidth,cornerHeight)
                .topRight(cornerWidth+centerWidth,0,cornerWidth,cornerHeight)
                .left(0,cornerHeight,cornerWidth,centerHeight)
                .center(cornerWidth,cornerHeight,centerWidth,centerHeight)
                .right(cornerWidth+centerWidth,cornerHeight,cornerWidth,centerHeight)
                .botLeft(0,cornerHeight+centerHeight,cornerWidth,cornerHeight)
                .bot(cornerWidth,cornerHeight+centerHeight,centerWidth,cornerHeight)
                .botRight(cornerWidth+centerWidth,cornerHeight+centerHeight,cornerWidth,cornerHeight);
        return builder.build(targetWidth,targetHeight);
    }
}
