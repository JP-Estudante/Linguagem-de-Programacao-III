module com.mycompany.coressortidas {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.coressortidas to javafx.fxml;
    exports com.mycompany.coressortidas;
}
