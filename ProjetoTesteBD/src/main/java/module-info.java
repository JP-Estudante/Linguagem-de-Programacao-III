module com.mycompany.projetotestebd {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.projetotestebd to javafx.fxml;
    exports com.mycompany.projetotestebd;
}
