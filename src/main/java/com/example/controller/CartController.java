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

public class CartController {

    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    private final double TAX_RATE = 0.06625;

    private MainController mainController;

    private Stage stage;

    private Scene primaryScene;

    private Stage primaryStage;

    @FXML
    public ListView<MenuItem> lv_cart;

    @FXML
    private TextField tf_subtotal;

    @FXML
    private TextField tf_salestax;

    @FXML
    private TextField tf_totalamt;

    @FXML
    private void initialize() {
        tf_subtotal.setEditable(false);
        tf_subtotal.setFocusTraversable(false);
        tf_salestax.setEditable(false);
        tf_salestax.setFocusTraversable(false);
        tf_totalamt.setEditable(false);
        tf_totalamt.setFocusTraversable(false);
    }

    @FXML
    public void placeOrder(MenuItem item) {
        lv_cart.getItems().add(item);
    }

    @FXML
    public void removeOrder() {
        lv_cart.getItems().remove(lv_cart.getSelectionModel().getSelectedItem());
        updateTotals();
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

    public void refreshCartDisplay() {
        // Refresh the ListView or other components as needed
        lv_cart.refresh(); // If using an ObservableList, this may not be necessary
        updateTotals(); // Example method to update subtotal, tax, total
    }

    private void updateTotals() {
        double subtotal = calculateSubtotal();
        double tax = subtotal * TAX_RATE;// Example tax calculation
        double total = subtotal + tax;

        tf_subtotal.setText(formatter.format(subtotal));
        tf_salestax.setText(formatter.format(tax));
        tf_totalamt.setText(formatter.format(total));
    }

    private double calculateSubtotal() {
        double subtotal = 0.0;
        for (MenuItem item : lv_cart.getItems()) {
            subtotal += item.price();
        }
        return subtotal;
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

    @FXML
    public void sendOrder() {
        ArrayList<MenuItem> items = new ArrayList<>(lv_cart.getItems());
        OrderController orderController = mainController.getOrderViewController();
        orderController.addOrder(new Order(items));
        lv_cart.getItems().clear();
        refreshCartDisplay();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Order Placed");
        alert.showAndWait();
    }

}

