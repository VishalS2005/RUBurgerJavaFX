package com.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button bt_burger;

    @FXML
    private Button bt_sandwich;

    @FXML
    private Button bt_beverage;

    @FXML
    private Button bt_side;

    private Stage primaryStage; //the reference of the main window.
    private Scene primaryScene; //the ref. of the scene set to the primaryStage

    /**
     * Set the reference of the stage and scene before show()
     * @param stage the stage used to display the scene
     * @param scene the scene set to the stage
     */
    public void setPrimaryStage(Stage stage, Scene scene) {
        primaryStage = stage;
        primaryScene = scene;
    }

    /**
     * When the image button is clicked, a new window(stage) will be displayed.
     * The scene graph associated with the window is second-view.fxml, in which the
     * fx:controller attribute defines the controller as SecondViewController.
     * When the fxml file is loading, an instance of SecondController will be created
     * To get the reference of the controller, use the getController() method.
     */
    @FXML
    protected void displayBurgerView() {
        Stage view1 = new Stage(); //if we want to use a new window
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/burger-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 600, 524);
            //view1.setScene(scene); //if we want to use the new window to draw the scene graph
            //view1.setTitle("view1");
            //view1.show();
            primaryStage.setScene(scene);
            BurgerController burgerViewController = loader.getController();
            /*
              The statement below is to pass the references of the MainController objects
              to the SecondViewController object so the SecondViewController can call the
              public methods in the MainController or to navigate back to the main view.
             */
            burgerViewController.setMainController(this, view1, primaryStage, primaryScene);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading burger-view.fxml.");
            alert.setContentText("Couldn't load burger-view.fxml.");
            alert.showAndWait();
        }
    }

    @FXML
    protected void displaySandwichView() {
        Stage view1 = new Stage(); //if we want to use a new window
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sandwich-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 600, 524);
            //view1.setScene(scene); //if we want to use the new window to draw the scene graph
            //view1.setTitle("view1");
            //view1.show();
            primaryStage.setScene(scene);
            SandwichController sandwichViewController = loader.getController();
            /*
              The statement below is to pass the references of the MainController objects
              to the SecondViewController object so the SecondViewController can call the
              public methods in the MainController or to navigate back to the main view.
             */
            sandwichViewController.setMainController(this, view1, primaryStage, primaryScene);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading sandwich-view.fxml.");
            alert.setContentText("Couldn't load sandwich-view.fxml.");
            alert.showAndWait();
        }
    }

    /**
     * When the image button is clicked, a new window(stage) will be displayed.
     * The scene graph associated with the window is second-view.fxml, in which the
     * fx:controller attribute defines the controller as SecondViewController.
     * When the fxml file is loading, an instance of SecondController will be created
     * To get the reference of the controller, use the getController() method.
     */
    @FXML
    protected void displayCartView() {
        Stage view1 = new Stage(); //if we want to use a new window
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cart-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 600, 524);
            //view1.setScene(scene); //if we want to use the new window to draw the scene graph
            //view1.setTitle("view1");
            //view1.show();
            primaryStage.setScene(scene);
            CartController cartViewController = loader.getController();
            /*
              The statement below is to pass the references of the MainController objects
              to the SecondViewController object so the SecondViewController can call the
              public methods in the MainController or to navigate back to the main view.
             */
            cartViewController.setMainController(this, view1, primaryStage, primaryScene);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading cart-view.fxml.");
            alert.setContentText("Couldn't load cart-view.fxml.");
            alert.showAndWait();
        }
    }

    @FXML
    protected void displayBeverageView() {
        Stage view1 = new Stage(); //if we want to use a new window
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/beverage-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 600  , 524);
            //view1.setScene(scene); //if we want to use the new window to draw the scene graph
            //view1.setTitle("view1");
            //view1.show();
            primaryStage.setScene(scene);
            BeverageController beverageViewController = loader.getController();
            /*
              The statement below is to pass the references of the MainController objects
              to the SecondViewController object so the SecondViewController can call the
              public methods in the MainController or to navigate back to the main view.
             */
            beverageViewController.setMainController(this, view1, primaryStage, primaryScene);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading beverage-view.fxml.");
            alert.setContentText("Couldn't load beverage-view.fxml.");
            alert.showAndWait();
        }
    }


    @FXML
    private void mouseEnterBurger() {
        bt_burger.setStyle("-fx-background-color: #decb6b");
    }

    @FXML
    private void mouseExitBurger() {
        bt_burger.setStyle("-fx-background-color: #FFFFFF");
    }

    @FXML
    private void sandwichClicked() {}

    @FXML
    private void mouseEnterSandwich() {
        bt_sandwich.setStyle("-fx-background-color: #decb6b");
    }

    @FXML
    private void mouseExitSandwich() {
        bt_sandwich.setStyle("-fx-background-color: #FFFFFF");
    }

    @FXML
    private void beverageClicked() {}

    @FXML
    private void mouseEnterBeverage() {
        bt_beverage.setStyle("-fx-background-color: #decb6b");
    }

    @FXML
    private void mouseExitBeverage() {
        bt_beverage.setStyle("-fx-background-color: #FFFFFF");
    }

    @FXML
    private void sideClicked() {}

    @FXML
    private void mouseEnterSide() {
        bt_side.setStyle("-fx-background-color: #decb6b");
    }

    @FXML
    private void mouseExitSide() {
        bt_side.setStyle("-fx-background-color: #FFFFFF");
    }

    @FXML
    private void currentOrderClicked() {}

    @FXML
    private void placedOrderClicked() {}

}