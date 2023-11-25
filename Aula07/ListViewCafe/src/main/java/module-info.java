module company.listviewcafe {
    requires javafx.controls;
    requires javafx.fxml;

    opens company.listviewcafe to javafx.fxml;
    exports company.listviewcafe;
}
