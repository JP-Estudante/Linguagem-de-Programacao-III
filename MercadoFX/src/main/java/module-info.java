module mercadofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens mercadofx to javafx.fxml;
    opens Models to javafx.base;
    
    exports mercadofx;
}
