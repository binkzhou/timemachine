module com.example.timemachine {
    requires javafx.controls;
    requires javafx.fxml;
        requires org.controlsfx.controls;
    requires lombok;
    requires java.sql;
    requires log4j;
    requires commons.codec;
    requires httpclient;
    requires httpcore;
    requires httpmime;
    opens com.timemachine to javafx.fxml;
    exports com.timemachine;
    exports com.timemachine.ui;
    opens com.timemachine.ui to javafx.fxml;
    opens com.timemachine.bean to javafx.base;
}