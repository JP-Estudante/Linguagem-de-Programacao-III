module com.mycompany.projetosenha {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.projetosenha to javafx.fxml;
    exports com.mycompany.projetosenha;
}
