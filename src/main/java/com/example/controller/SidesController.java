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

/**
 * This class controls the "Sides" view in the application, managing user input for sides, size,
 * quantity, and price. It facilitates navigation and interaction with the main controller and cart.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public class SidesController {

    /**
     * Formatter for displaying currency in US locale.
     */
    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    /**
     * Reference to the main controller for accessing shared resources and methods.
     */
    private MainController mainController;

    /**
     * The primary stage for the application.
     */
    private Stage primaryStage;

    /**
     * The primary scene for returning to the main view.
     */
    private Scene primaryScene;

    /**
     * Text field displaying the calculated price of the selected sides.
     */
    @FXML
    private TextField tf_price;

    /**
     * ComboBox for selecting the type of side dish.
     */
    @FXML
    private ComboBox<Side> cb_side;

    /**
     * ComboBox for selecting the size of the side dish.
     */
    @FXML
    private ComboBox<Size> cb_size;

    /**
     * ComboBox for selecting the quantity of side dishes.
     */
    @FXML
    private ComboBox<Integer> cb_quantity;

    /**
     * Initializes the "Sides" view with default values for quantity, sides, and size.
     * Sets up ComboBox items and configures the price field properties.
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

    /**
     * Updates the price field with the calculated cost of the selected sides.
     */
    @FXML
    private void setPrice() {
        Sides sides = getSides();
        tf_price.setText(formatter.format(sides.price()));
    }

    /**
     * Creates a new Sides object based on the current selections for side, size, and quantity.
     *
     * @return A Sides object with the specified side, size, and quantity.
     */
    private Sides getSides() {
        return new Sides(cb_side.getValue(), cb_size.getValue(), cb_quantity.getValue());
    }

    /**
     * Handles the "Order" button click event, placing the selected sides in the cart.
     * Shows a confirmation alert to the user.
     */
    @FXML
    private void orderOnClick() {
        CartController cartController = mainController.getCartViewController();
        cartController.placeOrder(getSides());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Ordering Sides");
        alert.setContentText("Sides added to order.");
        alert.showAndWait();
    }

    /**
     * Assigns references to the main controller, primary stage, and primary scene.
     * These references enable communication and navigation within the application.
     *
     * @param controller Reference to the MainController object.
     * @param primaryStage The primary Stage object for the application.
     * @param primaryScene The primary Scene object for the application.
     */
    public void setMainController(MainController controller, Stage primaryStage, Scene primaryScene) {
        mainController = controller;
        this.primaryStage = primaryStage;
        this.primaryScene = primaryScene;
    }

    /**
     * Displays the main view by setting the primary stage to the main scene.
     */
    @FXML
    public void displayMain() {
        this.primaryStage.setScene(primaryScene);
        this.primaryStage.show();
    }
}

