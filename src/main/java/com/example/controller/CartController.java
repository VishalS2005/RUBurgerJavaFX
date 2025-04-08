package com.example.controller;

import com.example.model.*;
import com.example.model.MenuItem;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Controller class for managing the shopping cart functionality.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public class CartController {

    /**
     * Number formatter for currency values in US locale.
     */
    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    /**
     * Constant tax rate applied to orders.
     */
    private final double TAX_RATE = 0.06625;

    /**
     * Reference to the main controller.
     */
    private MainController mainController;

    /**
     * Primary stage for this controller.
     */
    private Stage primaryStage;

    /**
     * Primary scene for this controller.
     */
    private Scene primaryScene;

    /**
     * TextField displaying the subtotal amount.
     */
    @FXML
    private TextField tf_subtotal;

    /**
     * TextField displaying the sales tax amount.
     */
    @FXML
    private TextField tf_salestax;

    /**
     * TextField displaying the total amount.
     */
    @FXML
    private TextField tf_totalamt;

    /**
     * ListView displaying items in the cart.
     */
    @FXML
    public ListView<MenuItem> lv_cart;

    /**
     * Initializes the controller class. Sets up the text fields to be non-editable
     * and non-focusable.
     */
    @FXML
    private void initialize() {
        this.tf_subtotal.setEditable(false);
        this.tf_subtotal.setFocusTraversable(false);
        this.tf_salestax.setEditable(false);
        this.tf_salestax.setFocusTraversable(false);
        this.tf_totalamt.setEditable(false);
        this.tf_totalamt.setFocusTraversable(false);
    }

    /**
     * Calculates and updates the subtotal, tax, and total amounts displayed in the UI.
     * Uses predefined formatting for numeric values.
     */
    private void updateTotals() {
        double subtotal = calculateSubtotal();
        double tax = subtotal * TAX_RATE; // Example tax calculation.
        double total = subtotal + tax;

        this.tf_subtotal.setText(this.formatter.format(subtotal));
        this.tf_salestax.setText(this.formatter.format(tax));
        this.tf_totalamt.setText(this.formatter.format(total));
    }

    /**
     * Calculates the subtotal amount for the items in the cart.
     *
     * @return The calculated subtotal as a double value.
     */
    private double calculateSubtotal() {
        double subtotal = 0.0;
        for (MenuItem item : this.lv_cart.getItems()) {
            subtotal += item.price();
        }
        return subtotal;
    }

    /**
     * Adds a menu item to the cart.
     * @param item The menu item to be added to the cart
     */
    @FXML
    public void placeOrder(MenuItem item) {
        this.lv_cart.getItems().add(item);
    }

    /**
     * Removes the selected item from the cart and updates the total amounts.
     */
    @FXML
    public void removeOrder() {
        this.lv_cart.getItems().remove(this.lv_cart.getSelectionModel().getSelectedItem());
        updateTotals();
    }

    /**
     * Sends the current order to the OrderController and clears the cart.
     * Displays a confirmation alert after successfully placing the order.
     */
    @FXML
    public void sendOrder() {
        ArrayList<MenuItem> items = new ArrayList<>(this.lv_cart.getItems());
        OrderController orderController = this.mainController.getOrderViewController();
        orderController.addOrder(new Order(items));
        this.lv_cart.getItems().clear();
        refreshCartDisplay();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Order Placed");
        alert.showAndWait();
    }

    /**
     * Refreshes the cart display by updating the ListView and other related components.
     * Also updates subtotal, tax, and total amounts using helper methods.
     */
    public void refreshCartDisplay() {
        this.lv_cart.refresh(); // Refresh the ListView if necessary.
        updateTotals();    // Updates subtotal, tax, and total amounts.
    }

    /**
     * Sets the reference to the MainController object, Stage, and Scene.
     * Enables calling public methods in the controller through the provided reference.
     *
     * @param controller   Reference to the MainController object.
     * @param primaryStage The primary stage of the application.
     * @param primaryScene The primary scene to display when navigating back.
     */
    public void setMainController(MainController controller,
                                  Stage primaryStage,
                                  Scene primaryScene) {
        this.mainController = controller;
        this.primaryStage = primaryStage;
        this.primaryScene = primaryScene;
    }

    /**
     * Navigates back to the main view by setting the primary scene on the stage.
     * Ensures the primary stage is displayed correctly.
     */
    @FXML
    public void displayMain() {
        this.primaryStage.setScene(this.primaryScene);
        this.primaryStage.show();
    }
}

