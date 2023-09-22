module com.mycompany.bindingsliders {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.bindingsliders to javafx.fxml;
    exports com.mycompany.bindingsliders;
}
