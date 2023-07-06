package com.timeMachine.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Main {

    @FXML
    private VBox left;

    @FXML
    private BorderPane pane;

    private HBox backUi;

    private HBox targetUi;

    @FXML
    private void onMenuButtonClick(MouseEvent event) throws Exception {
        ToggleButton clickedButton = (ToggleButton) event.getSource();
        clickedButton.setSelected(!clickedButton.isSelected());
        String text = clickedButton.getText();
        if(text.equals("备份目录")){
            pane.setCenter(this.backUi);
        }else if(text.equals("目标目录")){
            pane.setCenter(this.targetUi);
//            pane.setCenter(new Button());
        }else {
            pane.setCenter(new Button());
        }

        // 更新样式
        left.getChildren().forEach(node -> {
            if (node instanceof ToggleButton button) {
                button.getStyleClass().remove("menu-button-select");
            }
        });
        clickedButton.getStyleClass().add("menu-button-select");
    }

    public void initialize() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/view/back.fxml"));
        this.backUi = (HBox)fxmlLoader.load();
        pane.setCenter(this.backUi);
        FXMLLoader fxmlTargetLoader = new FXMLLoader(App.class.getResource("/view/target.fxml"));
        this.targetUi = (HBox)fxmlTargetLoader.load();
    }
}
