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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    @FXML
    private VBox left;

    @FXML
    private TableView<Backuproot> center;

    @FXML
    private void onMenuButtonClick(MouseEvent event) throws Exception {
        ToggleButton clickedButton = (ToggleButton) event.getSource();
//        new Add().start(new Stage());
        // 切换按钮的选中状态
        clickedButton.setSelected(!clickedButton.isSelected());
        System.out.println("666");
//        clickedButton.getStyleClass().add("menu-button-select");
//        System.out.println(clickedButton.getStyleClass());
        // 更新样式
        left.getChildren().forEach(node -> {
            if (node instanceof ToggleButton) {
                ToggleButton button = (ToggleButton) node;
                button.getStyleClass().remove("menu-button-select");
            }
        });
        clickedButton.getStyleClass().add("menu-button-select");
//        if (clickedButton.isSelected()) {
//            System.out.println("666");
//            clickedButton.getStyleClass().add("menu-button-select");
//        } else {
//            System.out.println("777");
//            System.out.println(clickedButton.getStyleClass());
//            clickedButton.getStyleClass().add("menu-button-select");
////            clickedButton.getStyleClass().remove("menu-button-selected");
//        }
    }
    @FXML
    protected void onHelloButtonClick() {
//        System.out.println("点击了");
//        left.getChildren();
//        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/view/main.fxml"));
        BorderPane root = (BorderPane)fxmlLoader.load();
        System.out.println(root);
        Scene scene = new Scene(root, 700, 500);
        scene.getStylesheets().add(App.class.getResource("/css/style.css").toExternalForm());

        //中 表格
//        TableView<Backuproot> table=new TableView<>();
//
//        List<TableColumn<Backuproot, ?>> columns = new ArrayList<>();
//        TableColumn<Backuproot,Integer> c1=new TableColumn<>("ID");
//        TableColumn<Backuproot,String> c2=new TableColumn<>("路径");
//
//        c1.setCellValueFactory(new PropertyValueFactory<>("id"));
//        c2.setCellValueFactory(new PropertyValueFactory<>("rootpath"));
//        columns.add(c1);
//        columns.add(c2);
//        table.getColumns().addAll(columns);

        // 创建ObservableList对象并添加数据
//        ObservableList<Backuproot> data = FXCollections.observableArrayList();
//        ObservableList<Backuproot> all = BackuprootDao.all();
//        System.out.println(all);
//        data.add(new Backuproot(1, "John"));
//        data.add(new Backuproot(2, "Jane"));
//        data.add(new Backuproot(3, "Mike"));
//        table.setItems(all);

//        root.setCenter(table);

        // 创建数据列表
//        ObservableList<String> data = FXCollections.observableArrayList(
//                "Item 1", "Item 2", "Item 3", "Item 4", "Item 5");
//
//        // 创建ListView并设置数据源
//        ListView<String> listView = new ListView<>(data);
//        root.setCenter(listView);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}