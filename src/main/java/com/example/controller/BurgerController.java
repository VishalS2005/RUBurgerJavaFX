package com.example.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class BurgerController {

    private MainController mainController;

    private Stage stage;

    private Scene primaryScene;

    private Stage primaryStage;

    @FXML
    private ComboBox<Integer> cb_quantity;

    @FXML
    private ToggleGroup patty_types;

    @FXML
    private ToggleGroup bread_types;

    @FXML
    private ToggleGroup topping_types;

    @FXML
    private RadioButton rb_single;

    @FXML
    private RadioButton rb_double;

    @FXML
    private RadioButton rb_brioche;

    @FXML
    private RadioButton rb_wheat;

    @FXML
    private RadioButton rb_pretzel;

    @FXML
    private CheckBox cb_lettuce;

    @FXML
    private CheckBox cb_tomato;

    @FXML
    private CheckBox cb_onion;

    @FXML
    private CheckBox cb_avocado;

    @FXML
    private CheckBox cb_cheese;

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
    private void initialize() {
        cb_quantity.getItems().addAll(1, 2, 3, 4, 5);
        cb_quantity.setValue(1);
        cb_quantity.setVisibleRowCount(5);
    }

    @FXML
    public void displayMain() {
        //stage.close(); //close the window.
        this.primaryStage.setScene(primaryScene);
        this.primaryStage.show();
    }

    @FXML
    private void orderOnClick() {}

    @FXML
    private void comboOnClick() {

    }

}
