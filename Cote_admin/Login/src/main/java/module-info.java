module com.mycompany.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.login to javafx.fxml;
    opens Controllers to javafx.fxml;
    opens Classes to javafx.fxml;
    opens OracleSGBD;

    // Add a module dependency on the Oracle JDBC driver module
   
    exports com.mycompany.login;
}
