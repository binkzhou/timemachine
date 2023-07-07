package com.timeMachine.ui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/view/main.fxml"));
        BorderPane root = fxmlLoader.load();
        Scene scene = new Scene(root, 700, 500);
        scene.getStylesheets().add(Objects.requireNonNull(App.class.getResource("/css/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.setTitle("时间机器");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}