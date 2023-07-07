package com.timeMachine.ui;


import com.timeMachine.dao.ServiceRun;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.SQLException;

public class Run {
    @FXML
    private Button runBtn;

    private final ServiceRun serviceRun = new ServiceRun();

    public void initialize() throws IOException {
        serviceRun.init();
        serviceRun.setOnSucceeded(event -> {
            System.out.println("备份完成");
            runBtn.setDisable(false);
        });
    }
    @FXML
    private void runBack(){
        System.out.println("备份");

        System.out.println("备份");

        if (runBtn.isDisabled()) {
            System.out.println(runBtn.isDisabled());
            return;
        }
        runBtn.setDisable(true);

        serviceRun.restart();
    }
}
