package com.timemachine.ui;

import com.timemachine.bean.Backuproot;
import com.timemachine.dao.BackuprootDao;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    @FXML
    private VBox left;

    @FXML
    private ListView<String> listView;

    @FXML
    private BorderPane borderPane;

    @FXML
    private TableView<Backuproot> center;

    @FXML
    private HBox content1;
    public void initialize() {

        content1.setVisible(true);
//        ListView<String> listView = new ListView<>();
//        listView.getStyleClass().add("custom-list-view");
//        listView.setEditable(true);
        listView.setCellFactory(lv -> {
            TextFieldListCell<String> cell = new TextFieldListCell<String>() {
                @Override
                public void startEdit() {
                    super.startEdit();
                    setPrefHeight(30); // 设置编辑框的高度
                }
            };

            cell.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !cell.isEmpty()) {
                    listView.edit(listView.getSelectionModel().getSelectedIndex());
                }
            });
            return cell;
        });
        listView.getItems().addAll(
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
                "Item 5"
        );

    }
    @FXML
    private void onMenuButtonClick(MouseEvent event) throws Exception {
        ToggleButton clickedButton = (ToggleButton) event.getSource();
        clickedButton.setSelected(!clickedButton.isSelected());
        System.out.println("666");
//        Button button1 = new Button();
//        System.out.println(borderPane);
//        borderPane.setCenter(button1);
        // 更新样式
        left.getChildren().forEach(node -> {
            if (node instanceof ToggleButton) {
                ToggleButton button = (ToggleButton) node;
                button.getStyleClass().remove("menu-button-select");
            }
        });
        clickedButton.getStyleClass().add("menu-button-select");
    }
    @FXML
    protected void onHelloButtonClick() {
        //
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/view/main.fxml"));
        BorderPane root = (BorderPane)fxmlLoader.load();
        System.out.println(root);
        Scene scene = new Scene(root, 700, 500);
        scene.getStylesheets().add(App.class.getResource("/css/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}