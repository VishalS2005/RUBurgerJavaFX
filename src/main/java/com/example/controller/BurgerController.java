package com.example.controller;

import com.example.model.AddOns;
import com.example.model.Bread;
import com.example.model.Burger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class BurgerController {

    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    private MainController mainController;

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

    @FXML
    private TextField tf_price;

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
     * When the image button is clicked, a new window(stage) will be displayed.
     * The scene graph associated with the window is second-view.fxml, in which the
     * fx:controller attribute defines the controller as SecondViewController.
     * When the fxml file is loading, an instance of SecondController will be created
     * To get the reference of the controller, use the getController() method.
     */
    @FXML
    protected void comboOnClick() {
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/combo-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 600, 524);
            primaryStage.setScene(scene);
            ComboController comboViewController = loader.getController();
            comboViewController.setSandwich(getBurger());
            comboViewController.setMainController(mainController, primaryStage, primaryScene);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading combo-view.fxml.");
            alert.setContentText("Couldn't load combo-view.fxml.");
            alert.showAndWait();
        }
    }

    /**
     * Navigate back to the main view.
     */
    @FXML
    private void initialize() {
        cb_quantity.getItems().addAll(1, 2, 3, 4, 5);
        cb_quantity.setValue(1);
        cb_quantity.setVisibleRowCount(5);
        rb_single.setSelected(true);
        rb_brioche.setSelected(true);
        tf_price.setEditable(false);
        tf_price.setFocusTraversable(false);
        setPrice();

    }

    @FXML
    private void setPrice() {
       Burger burger = getBurger();
       tf_price.setText(formatter.format(burger.price()));
    }

    @FXML
    public void displayMain() {
        //stage.close(); //close the window.
        this.primaryStage.setScene(primaryScene);
        this.primaryStage.show();
    }


    private Burger getBurger() {
        boolean isDoublePatty = rb_double.isSelected();
        Bread bread = getBread();
        ArrayList<AddOns> addOns = getAddOns();
        int quantity = cb_quantity.getValue();
        return new Burger(bread, isDoublePatty, addOns, quantity);
    }

    private ArrayList<AddOns> getAddOns() {
       ArrayList<AddOns> addOns = new ArrayList<>();

       if(cb_lettuce.isSelected()) {
           addOns.add(AddOns.LETTUCE);
       }

       if(cb_tomato.isSelected()) {
            addOns.add(AddOns.TOMATOES);
       }
       if(cb_onion.isSelected()) {
            addOns.add(AddOns.ONIONS);
       }
       if(cb_avocado.isSelected()) {
            addOns.add(AddOns.AVOCADO);
       }
       if(cb_cheese.isSelected()) {
            addOns.add(AddOns.CHEESE);
       }

       return addOns;

    }

    private Bread getBread() {
        if (rb_brioche.isSelected()) {
            return Bread.BRIOCHE;
        } else if(rb_wheat.isSelected()) {
            return Bread.WHEAT_BREAD;
        } else if(rb_pretzel.isSelected()) {
            return Bread.PRETZEL;
        }
        return null;
    }

    @FXML
    private void orderOnClick() {
        CartController cartController = mainController.getCartViewController();
        cartController.placeOrder(getBurger());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Ordering Burger");
        alert.setContentText("Burger added to order.");
        alert.showAndWait();
    }

}
