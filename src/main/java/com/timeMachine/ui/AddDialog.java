package com.timeMachine.ui;

import com.timeMachine.bean.Backuproot;
import com.timeMachine.dao.BackuprootDao;
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

    /**
     * 选择的参数
     */
    private Backuproot backuproot;

    @FXML
    private TextField directoryPath;


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setParameters(Backuproot backuproot){
        this.backuproot = backuproot;
        this.directoryPath.setText(backuproot.getRootpath());
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    @FXML
    private void confirmAction() {
        System.out.println("confirm");
        String text = directoryPath.getText();
        if(!text.equals("")){
            if(backuproot==null){
                isConfirmed = BackuprootDao.add(text);
            }else {
                isConfirmed = BackuprootDao.edit(String.valueOf(backuproot.getId()),text);
            }
        }else {
            // 处理确认按钮的逻辑
            isConfirmed = false;
        }
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
