module com.timeMachine {
    requires javafx.controls;
    requires javafx.fxml;
        requires org.controlsfx.controls;
    requires static lombok;
    requires java.sql;
    requires log4j;
    requires commons.codec;
    requires httpclient;
    requires httpcore;
    requires httpmime;
    opens com.timeMachine to javafx.fxml;
    exports com.timeMachine;
    exports com.timeMachine.ui;
    opens com.timeMachine.ui to javafx.fxml;
    opens com.timeMachine.bean to javafx.base;
}