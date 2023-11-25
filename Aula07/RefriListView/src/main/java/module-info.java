module refrilistview {
    requires javafx.controls;
    requires javafx.fxml;

    opens refrilistview to javafx.fxml;
    exports refrilistview;
}
