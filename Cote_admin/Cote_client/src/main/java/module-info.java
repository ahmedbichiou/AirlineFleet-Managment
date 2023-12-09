module com.mycompany.cote_client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    

    opens com.mycompany.cote_client to javafx.fxml;
    opens classes to javafx.fxml;
    opens controllers to javafx.fxml;
    exports com.mycompany.cote_client;
}