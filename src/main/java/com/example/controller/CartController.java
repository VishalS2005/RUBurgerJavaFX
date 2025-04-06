package com.example.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.text.NumberFormat;
import java.util.Locale;

public class CartController {

    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    private MainController mainController;

    private Stage stage;

    private Scene primaryScene;

    private Stage primaryStage;

    @FXML
    public ListView<String> listView;

    @FXML
    private TextField tf_subtotal;

    @FXML
    private TextField tf_salestax;

    @FXML
    private TextField tf_totalamt;

    @FXML
    private void initialize() {

    }

    @FXML
    private void placeOrder() {}

    @FXML
    private void removeOrder() {}

    /**
     * Get the reference to the MainController object.
     * We can call any public method defined in the controller through the reference.
     */
    public void setMainController (MainController controller,
                                   Stage stage,
                                   Stage primaryStage,
                                   Scene primaryScene) {
        mainController = controller;
        this.stage = stage;
        this.primaryStage = primaryStage;
        this.primaryScene = primaryScene;
    }

    /**
     * Navigate back to the main view.
     */
    @FXML
    public void displayMain() {
        //stage.close(); //close the window.
        this.primaryStage.setScene(primaryScene);
        this.primaryStage.show();
    }
}

