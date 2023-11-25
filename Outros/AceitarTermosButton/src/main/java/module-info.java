module com.mycompany.aceitartermosbutton {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.aceitartermosbutton to javafx.fxml;
    exports com.mycompany.aceitartermosbutton;
}
