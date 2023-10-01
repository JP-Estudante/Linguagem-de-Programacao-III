module company.exemplolistview {
    requires javafx.controls;
    requires javafx.fxml;

    opens exemplolistview to javafx.fxml;
    exports exemplolistview;
}
