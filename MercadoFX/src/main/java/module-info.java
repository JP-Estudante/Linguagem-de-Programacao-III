module mercadofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive java.sql;
    requires transitive javafx.graphics;

    opens mercadofx to javafx.fxml;
    opens Models to javafx.base;
    
    exports mercadofx;
}
