package com.timeMachine.ui;

import com.timeMachine.bean.Backuproot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;

public class Target {
    @FXML
    private ListView<String> listView;

    public void initialize() throws IOException {


        listView.getItems().addAll(
                "目标 1",
                "目标 2",
                "目标 3",
                "目标 4",
                "目标 5"
        );

    }
}
