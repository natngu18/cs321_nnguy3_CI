module com.example.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires java.mail;

    opens com.example.javafxdemo to javafx.fxml;
    exports com.example.javafxdemo;
}