package com.example.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ComboController {

    private MainController mainController;

    private Stage stage;

    private Scene primaryScene;

    private Stage primaryStage;

    @FXML
    private TextField tf_sandwich;

    @FXML
    private TextField tf_price;

    @FXML
    private ComboBox<String> cb_sides;

    @FXML
    private ComboBox<String> cb_drinks;

    @FXML
    private ComboBox<Integer> cb_quantity;

    @FXML
    private void initialize() {
        try {
            // Initialize sides ComboBox
            cb_sides.getItems().addAll("Chips", "Apple");
            cb_sides.setValue("Chips");

            // Initialize drinks ComboBox
            cb_drinks.getItems().addAll("Cola", "Tea", "Juice");
            cb_drinks.setValue("Cola");

            // Initialize quantity ComboBox (now using Integer)
            cb_quantity.getItems().addAll(1, 2, 3, 4, 5);
            cb_quantity.setValue(1);

            // Set visible row counts
            cb_sides.setVisibleRowCount(2);
            cb_drinks.setVisibleRowCount(3);
            cb_quantity.setVisibleRowCount(5);
        } catch (Exception e) {
            System.err.println("Error initializing ComboBoxes: " + e.getMessage());
            e.printStackTrace();
        }
    }

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

    @FXML
    private void addOrder() {}

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

