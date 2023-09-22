module com.mycompany.bidingexample {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.bidingexample to javafx.fxml;
    exports com.mycompany.bidingexample;
}
