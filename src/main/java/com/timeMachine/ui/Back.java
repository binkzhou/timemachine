package com.timeMachine.ui;

import com.timeMachine.bean.Backuproot;
import com.timeMachine.dao.BackuprootDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Back {
    @FXML
    private ListView<Backuproot> listView;

    public void getAll(){
        ObservableList<Backuproot> all = BackuprootDao.all();
        listView.setItems(all);
    }

    public void initialize() throws IOException {

//        ObservableList<Backuproot> all = BackuprootDao.all();
//        ObservableList<String> items = FXCollections.observableArrayList();

//        ObservableList<Backuproot> items = FXCollections.observableArrayList(all);
//        listView.setItems(all);

        getAll();
        // 创建自定义的单元格工厂
        listView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Backuproot item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getRootpath());
                }
            }
        });

        // 获取ListView的选择模型
        MultipleSelectionModel<Backuproot> selectionModel = listView.getSelectionModel();
        // 监听选择改变事件
        selectionModel.selectedItemProperty().addListener((obs, oldSelected, newSelected) -> {
            if (newSelected != null) {
                // 在这里处理选中项的逻辑
                System.out.println("选中的项：" + newSelected.getId());
            }
        });
//        for (Backuproot backuproot : all) {
//            String item = "ID: " + backuproot.getId() + ", Content: " + backuproot.getRootpath();
//            items.add(item);
//        }
//
//        listView.setItems(items);

//        listView.getItems().addAll(
//                "Item 1",
//                "Item 2",
//                "Item 3",
//                "Item 4",
//                "Item 5"
//        );

    }


    @FXML
    private void addDir(){
        try {
            // 加载新建窗口的FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/add_dialog.fxml"));
            Parent root = loader.load();

            // 获取窗口的控制器
            AddDialog controller = loader.getController();


            // 设置传递的参数
//            controller.setParameters(/* 参数值 */);

            // 创建新建窗口的Stage对象
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setResizable(false);
            Scene scene = new Scene(root, 500, 200);
            controller.setDialogStage(dialogStage);

            scene.getStylesheets().add(Objects.requireNonNull(App.class.getResource("/css/style.css")).toExternalForm());
            dialogStage.setScene(scene);

            // 显示新建窗口并等待关闭
            dialogStage.showAndWait();

            // 处理新建窗口的返回结果
            boolean isConfirmed = controller.isConfirmed();
            System.out.println(isConfirmed);
            if (isConfirmed) {
                // 确认按钮被点击
                // 执行逻辑操作
            } else {
                // 取消按钮被点击或窗口被关闭
                // 执行其他操作
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void deleteDir(){
        Backuproot selectedItem = listView.getSelectionModel().getSelectedItem();
        System.out.println(selectedItem);

        boolean delete = BackuprootDao.delete(String.valueOf(selectedItem.getId()));
        if(delete){
            getAll();
        }
    }
}
