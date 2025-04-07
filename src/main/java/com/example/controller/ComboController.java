package com.example.controller;

import com.example.model.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ComboController {

    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    private MainController mainController;

    private Scene primaryScene;

    private Stage primaryStage;

    @FXML
    private TextField tf_sandwich;

    @FXML
    private TextField tf_price;

    @FXML
    private ComboBox<Side> cb_sides;

    @FXML
    private ComboBox<Flavor> cb_drinks;

    @FXML
    private ComboBox<Integer> cb_quantity;

    private Sandwich sandwich;

    @FXML
    private void initialize() {
        ArrayList<Side> sides = new ArrayList<>();
        sides.add(Side.CHIPS);
        sides.add(Side.APPLE_SLICES);
        cb_sides.getItems().addAll(sides);
        cb_sides.setValue(Side.CHIPS);
        ArrayList<Flavor> flavors = new ArrayList<>();
        flavors.add(Flavor.COLA);
        flavors.add(Flavor.TEA);
        flavors.add(Flavor.JUICE);
        cb_drinks.getItems().addAll(flavors);
        cb_drinks.setValue(Flavor.COLA);
        cb_quantity.getItems().addAll(1, 2, 3, 4, 5);
        cb_quantity.setValue(1);
    }

    /**
     * Get the reference to the MainController object.
     * We can call any public method defined in the controller through the reference.
     */
    public void setMainController (MainController controller,
                                   Stage primaryStage,
                                   Scene primaryScene) {
        this.mainController = controller;
        this.primaryStage = primaryStage;
        this.primaryScene = primaryScene;
    }

    @FXML
    private void addOrder() {
        Combo combo = new Combo(sandwich, getBeverage(), cb_sides.getValue(), cb_quantity.getValue());
        CartController cartController = mainController.getCartViewController();
        cartController.placeOrder(combo);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Ordering Combo");
        alert.setContentText("Combo added to order.");
        alert.showAndWait();
    }

    private Beverage getBeverage() {
        if(cb_drinks.getValue() == Flavor.COLA) {
            return new Beverage(Size.MEDIUM, Flavor.COLA, 1);
        } else if (cb_drinks.getValue() == Flavor.TEA) {
            return new Beverage(Size.MEDIUM, Flavor.TEA, 1);
        } else if (cb_drinks.getValue() == Flavor.JUICE) {
            return new Beverage(Size.MEDIUM, Flavor.JUICE, 1);
        }
        return null;
    }

    /**
     * Navigate back to the main view.
     */
    @FXML
    public void displayMain() {
        this.primaryStage.setScene(primaryScene);
        this.primaryStage.show();
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
        tf_sandwich.setText(sandwich.getIngredients());
        refresh();
        tf_price.setEditable(false);
        tf_price.setFocusTraversable(false);
        tf_sandwich.setEditable(false);
        tf_sandwich.setFocusTraversable(false);
    }

    @FXML
    public void refresh() {
        double price = new Combo(sandwich, getBeverage(), cb_sides.getValue(), cb_quantity.getValue()).price();
        tf_price.setText(formatter.format(price));
    }

}

