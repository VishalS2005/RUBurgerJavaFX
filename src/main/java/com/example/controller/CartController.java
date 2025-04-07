package com.example.controller;

import com.example.model.Beverage;
import com.example.model.Flavor;
import com.example.model.MenuItem;
import com.example.model.Size;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.text.NumberFormat;
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

    }

    @FXML
    public void placeOrder(MenuItem item) {
        lv_cart.getItems().add(item);
    }

    @FXML
    public void removeOrder() {}

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

    public Stage getCartStage() {
        return stage;
    }
}

