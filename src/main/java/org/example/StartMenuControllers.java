package org.example;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class StartMenuControllers {

    @FXML
    public ImageView startTitleView;
    @FXML
    public VBox startMenuBox;

    @FXML
    public void initialize(){
        try {

            Image image=new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/StartTitle.png")));
            startTitleView.setImage(image);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
