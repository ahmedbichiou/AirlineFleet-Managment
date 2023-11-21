module com.mycompany.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.login to javafx.fxml;
    exports com.mycompany.login;
}
