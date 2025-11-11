module MineTower {
    requires com.almasb.fxgl.all;
    requires javafx.graphics;
    requires javafx.fxml;

    opens org.example to javafx.fxml;
    exports org.example;
}