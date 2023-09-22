module com.mycompany.conversorcombobox {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.conversorcombobox to javafx.fxml;
    exports com.mycompany.conversorcombobox;
}
