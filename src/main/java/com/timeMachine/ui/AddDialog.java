package com.timeMachine.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class AddDialog {

    private boolean isConfirmed = false;

    private Stage dialogStage;

    @FXML
    private TextField directoryPath;


//    @FXML
//    private Button confirmButton;
//
//    @FXML
//    private Button cancelButton;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    @FXML
    private void confirmAction() {
        System.out.println("confirm");
        // 处理确认按钮的逻辑
        isConfirmed = true;
        closeDialog();
    }

    @FXML
    private void cancelAction() {
        // 处理取消按钮的逻辑
        closeDialog();
    }

    private void closeDialog() {
        if (dialogStage != null) {
            dialogStage.close();
        }
    }

    @FXML
    private void openFileExplorer(){
//        Stage stage = (Stage) selectPathButton.getScene().getWindow();
//        stage.hide(); // 隐藏父窗口
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("选择文件夹");
        File selectedDirectory = directoryChooser.showDialog(dialogStage);
        if (selectedDirectory != null) {
            String selectedPath = selectedDirectory.getAbsolutePath();
            directoryPath.setText(selectedPath);
            System.out.println("Selected Path: " + selectedPath);

            // 执行其他操作，例如将选择的路径显示在界面上
        }
    }
}
