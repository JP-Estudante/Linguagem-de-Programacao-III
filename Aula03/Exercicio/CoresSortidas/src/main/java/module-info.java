module jp.coressortidas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens jp.coressortidas to javafx.fxml;
    exports jp.coressortidas;
}
