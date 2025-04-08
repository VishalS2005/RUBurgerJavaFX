package com.example.controller;

import com.example.model.MenuItem;
import com.example.model.Order;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class OrderController {

    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    private double TAX_RATE = 1.06625;

    private MainController mainController;

    private Stage stage;

    private Scene primaryScene;

    private Stage primaryStage;

    @FXML
    private TextField tf_total;

    @FXML
    public ComboBox<Integer> cb_orderNum;

    @FXML
    public ListView<MenuItem> lv_menuItems;

    private Map<Integer, ArrayList<MenuItem>> orders = new HashMap<>();

    @FXML
    private void initialize() {
        tf_total.setEditable(false);
        tf_total.setFocusTraversable(false);
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

    /**
     * Navigate back to the main view.
     */
    @FXML
    public void displayMain() {
        this.primaryStage.setScene(primaryScene);
        this.primaryStage.show();
    }

    public void addOrder(Order order) {
        orders.put(order.getNumber(), order.getItems());
        cb_orderNum.getItems().add(order.getNumber());
        cb_orderNum.getSelectionModel().select(cb_orderNum.getItems().size() - 1);
        refresh();
    }

    @FXML
    public void cancelOrder() {
        Integer selectedOrderNumber = cb_orderNum.getValue();
        if (selectedOrderNumber != null) {
            orders.remove(selectedOrderNumber);
            cb_orderNum.getItems().remove(selectedOrderNumber);

            if (!cb_orderNum.getItems().isEmpty()) {
                cb_orderNum.getSelectionModel().select(0);
            } else {
                lv_menuItems.getItems().clear();
                tf_total.clear();
                return;
            }

            refresh();
        }
    }


    @FXML
    public void refresh() {
        lv_menuItems.getItems().clear(); // Clear the current items in the ListView.

        Integer selectedOrderNumber = cb_orderNum.getSelectionModel().getSelectedItem();
        if (selectedOrderNumber == null) {
            return;
        }

        ArrayList<MenuItem> items = orders.get(selectedOrderNumber);
        lv_menuItems.getItems().addAll(items);
        tf_total.setText(formatter.format(getPrice(items)));
    }


    public double getPrice(ArrayList<MenuItem> items) {
        double price = 0;
        for (MenuItem item : items) {
            price += item.price();
        }
        return TAX_RATE * price;
    }

    @FXML
    private void exportOrders() {
        if(cb_orderNum.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Please choose an order to export");
            alert.show();
            return;
        }
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName("Order #" + cb_orderNum.getValue());
        File file = fileChooser.showSaveDialog(primaryStage);
        if(file == null) {
            return;
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println("Order #" + cb_orderNum.getValue());
            ArrayList<MenuItem> items = orders.get(cb_orderNum.getValue());
            for(MenuItem menuItem : items) {
                printWriter.println(menuItem);
            }
            printWriter.println("Order total: " + tf_total.getText());
            printWriter.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


}

