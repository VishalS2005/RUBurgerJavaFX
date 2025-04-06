package com.example.controller;

import com.example.model.*;
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

public class SandwichController {

    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);


    private MainController mainController;

    private Stage stage;

    private Scene primaryScene;

    private Stage primaryStage;

    @FXML
    private RadioButton rb_roastBeef;

    @FXML
    private RadioButton rb_salmon;

    @FXML
    private RadioButton rb_chicken;

    @FXML
    private ComboBox<Integer> cb_quantity;

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

    @FXML
    private ComboBox<Bread> cb_bread;

    @FXML
    private void initialize() {
        cb_quantity.getItems().addAll(1, 2, 3, 4, 5);
        cb_quantity.setValue(1);
        cb_quantity.setVisibleRowCount(5);
        cb_bread.getItems().addAll(Bread.values());
        cb_bread.setValue(Bread.BRIOCHE);
        rb_roastBeef.setSelected(true);

        tf_price.setEditable(false);
        tf_price.setFocusTraversable(false);
        setPrice();
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

    /**
     * When the image button is clicked, a new window(stage) will be displayed.
     * The scene graph associated with the window is second-view.fxml, in which the
     * fx:controller attribute defines the controller as SecondViewController.
     * When the fxml file is loading, an instance of SecondController will be created
     * To get the reference of the controller, use the getController() method.
     */
    @FXML
    protected void comboOnClick() {
        Stage view1 = new Stage(); //if we want to use a new window
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/combo-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 600, 524);
            //view1.setScene(scene); //if we want to use the new window to draw the scene graph
            //view1.setTitle("view1");
            //view1.show();
            primaryStage.setScene(scene);
            ComboController comboViewController = loader.getController();
            /*
              The statement below is to pass the references of the MainController objects
              to the SecondViewController object so the SecondViewController can call the
              public methods in the MainController or to navigate back to the main view.
             */
            comboViewController.setSandwich(getSandwich());
            comboViewController.setMainController(mainController, view1, primaryStage, primaryScene);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading combo-view.fxml.");
            alert.setContentText("Couldn't load combo-view.fxml.");
            alert.showAndWait();
        }
    }

    @FXML
    private void setPrice() {
        Sandwich sandwich = getSandwich();
        tf_price.setText(formatter.format(sandwich.price()));
    }

    private Bread getBread() {
        return cb_bread.getValue();
    }

    private Protein getProtein() {
        if(rb_roastBeef.isSelected()) {
            return Protein.ROAST_BEEF;
        } else if(rb_salmon.isSelected()) {
            return Protein.SALMON;
        } else if (rb_chicken.isSelected()) {
           return Protein.CHICKEN;
        }
        return null;
    }

    private Sandwich getSandwich() {
        Bread bread = getBread();
        Protein protein = getProtein();
        ArrayList<AddOns> addOns = getAddOns();
        int quantity = cb_quantity.getValue();
        return new Sandwich(bread, protein, addOns, quantity);
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
    @FXML
    public void displayMain() {
        //stage.close(); //close the window.
        this.primaryStage.setScene(primaryScene);
        this.primaryStage.show();
    }

    @FXML
    private void orderOnClick() {}

}
