module jp.colorpickerproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens jp.colorpickerproject to javafx.fxml;
    exports jp.colorpickerproject;
}
