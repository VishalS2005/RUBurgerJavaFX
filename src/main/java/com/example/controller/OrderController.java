package com.example.controller;

import com.example.model.MenuItem;
import com.example.model.Order;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * The OrderController class manages the user interface for viewing and managing orders.
 * It handles interactions with orders, menu items, and total price display.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public class OrderController {

    /**
     * Formatter for displaying currency in US locale format.
     */
    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    /**
     * Tax rate applied to orders for calculating totals.
     */
    private double TAX_RATE = 1.06625;

    /**
     * Reference to the MainController, used to facilitate communication with the main application.
     */
    private MainController mainController;

    /**
     * The primary stage of the application, used for managing the main window.
     */
    private Stage primaryStage;

    /**
     * The primary scene used for navigation to the main view.
     */
    private Scene primaryScene;

    /**
     * TextField for displaying the total price of the currently selected order.
     * This field is non-editable and displays formatted totals.
     */
    @FXML
    private TextField tf_total;

    /**
     * ComboBox for selecting the order number from the list of available orders.
     */
    @FXML
    public ComboBox<Integer> cb_orderNum;

    /**
     * ListView for displaying menu items associated with the currently selected order.
     */
    @FXML
    public ListView<MenuItem> lv_menuItems;

    /**
     * Map for storing orders. Each order is associated with a unique order number as the key
     * and a list of MenuItem objects representing the items in the order as the value.
     */
    private Map<Integer, ArrayList<MenuItem>> orders = new HashMap<>();

    /**
     * Initializes the UI components of the OrderController.
     * Ensures that the total price TextField is non-editable and not focusable by the user.
     */
    @FXML
    private void initialize() {
        this.tf_total.setEditable(false);
        this.tf_total.setFocusTraversable(false);
    }

    /**
     * Adds a new order to the list of orders and updates the ComboBox for order selection.
     * Automatically selects the newly added order in the ComboBox.
     *
     * @param order The Order object to be added to the list of orders.
     */
    public void addOrder(Order order) {
        this.orders.put(order.getNumber(), order.getItems());
        this.cb_orderNum.getItems().add(order.getNumber());
        this.cb_orderNum.getSelectionModel().select(this.cb_orderNum.getItems().size() - 1);
        refresh();
    }

    /**
     * Cancels the currently selected order by removing it from the list of orders.
     * Updates the UI components accordingly. If no orders remain, clears the ListView and total price.
     */
    @FXML
    public void cancelOrder() {
        Integer selectedOrderNumber = this.cb_orderNum.getValue();
        if (selectedOrderNumber != null) {
            this.orders.remove(selectedOrderNumber);
            this.cb_orderNum.getItems().remove(selectedOrderNumber);

            if (!this.cb_orderNum.getItems().isEmpty()) {
                this.cb_orderNum.getSelectionModel().select(0);
            } else {
                this.lv_menuItems.getItems().clear();
                this.tf_total.clear();
                return;
            }
            refresh();
        }
    }

    /**
     * Refreshes the ListView and total price TextField to reflect the currently selected order.
     * Clears the ListView if no order is selected.
     */
    @FXML
    public void refresh() {
        this.lv_menuItems.getItems().clear(); // Clear the current items in the ListView.

        Integer selectedOrderNumber = this.cb_orderNum.getSelectionModel().getSelectedItem();
        if (selectedOrderNumber == null) {
            return;
        }

        ArrayList<MenuItem> items = this.orders.get(selectedOrderNumber);
        this.lv_menuItems.getItems().addAll(items);
        this.tf_total.setText(formatter.format(getPrice(items)));
    }

    /**
     * Calculates the total price of the given list of menu items, including tax.
     *
     * @param items The list of MenuItem objects for which the total price will be calculated.
     * @return The total price of the items, including tax.
     */
    public double getPrice(ArrayList<MenuItem> items) {
        double price = 0;
        for (MenuItem item : items) {
            price += item.price();
        }
        return TAX_RATE * price;
    }

    /**
     * Sets the reference to the MainController, primary stage, and primary scene.
     * Enables interaction with the MainController's public methods and facilitates scene navigation.
     *
     * @param controller   The MainController object reference.
     * @param primaryStage The primary stage of the application.
     * @param primaryScene The primary scene to return to when navigating back.
     */
    public void setMainController(MainController controller,
                                  Stage primaryStage,
                                  Scene primaryScene) {
        this.mainController = controller;
        this.primaryStage = primaryStage;
        this.primaryScene = primaryScene;
    }

    /**
     * Navigates back to the main view by setting the primary scene on the primary stage.
     */
    @FXML
    public void displayMain() {
        this.primaryStage.setScene(this.primaryScene);
        this.primaryStage.show();
    }
}

