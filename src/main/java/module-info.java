module com.example.project4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.model to javafx.fxml;
    exports com.example.model;
    exports com.example.controller;
    opens com.example.controller to javafx.fxml;
}