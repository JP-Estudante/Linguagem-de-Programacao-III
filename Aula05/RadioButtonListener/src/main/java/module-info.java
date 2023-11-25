module jp.radiobuttonlistener {
    requires javafx.controls;
    requires javafx.fxml;

    opens jp.radiobuttonlistener to javafx.fxml;
    exports jp.radiobuttonlistener;
}
