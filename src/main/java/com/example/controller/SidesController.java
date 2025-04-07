package com.example.controller;

import com.example.model.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.text.NumberFormat;
import java.util.Locale;

public class SidesController {

    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);


    private MainController mainController;

    private Stage stage;

    private Scene primaryScene;

    private Stage primaryStage;

    @FXML
    private TextField tf_price;

    @FXML
    private ComboBox<Side> cb_side;

    @FXML
    private ComboBox<Size> cb_size;

    @FXML
    private ComboBox<Integer> cb_quantity;


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
        cb_side.getItems().addAll(Side.values());
        cb_side.setValue(Side.CHIPS);
        cb_size.getItems().addAll(Size.values());
        cb_size.setValue(Size.SMALL);
        tf_price.setEditable(false);
        tf_price.setFocusTraversable(false);
        setPrice();
    }

    @FXML
    private void setPrice() {
        Sides sides = getSides();
        tf_price.setText(formatter.format(sides.price()));
    }

    private Sides getSides() {
        return new Sides(cb_side.getValue(), cb_size.getValue(), cb_quantity.getValue());
    }

    @FXML
    public void displayMain() {
        //stage.close(); //close the window.
        this.primaryStage.setScene(primaryScene);
        this.primaryStage.show();
    }


    @FXML
    private void orderOnClick() {
        CartController cartController = mainController.getCartViewController();
        cartController.placeOrder(getSides());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Ordering Sides");
        alert.setContentText("Sides added to order.");
        alert.showAndWait();
    }

}
