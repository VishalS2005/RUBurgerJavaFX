package com.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main controller class for handling navigation between different views in the application.
 * Manages the primary stage and scenes for burger, sandwich, beverage, sides, cart, and order views.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public class MainController {

    /**
     * The primary stage of the application.
     */
    private Stage primaryStage;

    /**
     * The primary scene of the application.
     */
    private Scene primaryScene;

    /**
     * Controller for the cart view.
     */
    private CartController cartViewController;

    /**
     * Scene for the cart view.
     */
    private Scene cartScene;

    /**
     * Controller for the order view.
     */
    private OrderController orderViewController;

    /**
     * Scene for the order view.
     */
    private Scene orderScene;

    /**
     * Button for navigating to the burger view.
     */
    @FXML
    private Button bt_burger;

    /**
     * Button for navigating to the sandwich view.
     */
    @FXML
    private Button bt_sandwich;

    /**
     * Button for navigating to the beverage view.
     */
    @FXML
    private Button bt_beverage;

    /**
     * Button for navigating to the sides view.
     */
    @FXML
    private Button bt_side;

    /**
     * Button for navigating to the cart view.
     */
    @FXML
    private Button bt_cart;

    /**
     * Button for navigating to the order view.
     */
    @FXML
    private Button bt_order;

    /**
     * Loads and displays the burger view when the burger button is clicked.
     * Sets up the controller communication between main and burger views.
     * Shows an error if burger-view.fxml file cannot be loaded.
     */
    @FXML
    protected void displayBurgerView() {
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/burger-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 600, 524);
            this.primaryStage.setScene(scene);
            BurgerController burgerViewController = loader.getController();
            burgerViewController.setMainController(this, this.primaryStage, this.primaryScene);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading burger-view.fxml.");
            alert.setContentText("Couldn't load burger-view.fxml.");
            alert.showAndWait();
        }
    }

    /**
     * Loads and displays the burger view when the sandwich button is clicked.
     * Sets up the controller communication between main and sandwich views.
     * Shows an error if sandwich-view.fxml file cannot be loaded.
     */
    @FXML
    protected void displaySandwichView() {
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sandwich-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 600, 524);
            this.primaryStage.setScene(scene);
            SandwichController sandwichViewController = loader.getController();
            sandwichViewController.setMainController(this, this.primaryStage, this.primaryScene);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading sandwich-view.fxml.");
            alert.setContentText("Couldn't load sandwich-view.fxml.");
            alert.showAndWait();
        }
    }

    /**
     * Loads and displays the sides view when the sides button is clicked.
     * Sets up the controller communication between main and sides views.
     * Shows an error if sides-view.fxml file cannot be loaded.
     */
    @FXML
    protected void displaySidesView() {
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sides-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 600, 524);
            this.primaryStage.setScene(scene);
            SidesController sidesViewController = loader.getController();
            sidesViewController.setMainController(this, this.primaryStage, this.primaryScene);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading sides-view.fxml.");
            alert.setContentText("Couldn't load sides-view.fxml.");
            alert.showAndWait();
        }
    }

    /**
     * Loads and displays the beverage view when the beverage button is clicked.
     * Sets up the controller communication between main and beverage views.
     * Shows an error if beverage-view.fxml file cannot be loaded.
     */
    @FXML
    protected void displayBeverageView() {
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/beverage-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 600  , 524);
            this.primaryStage.setScene(scene);
            BeverageController beverageViewController = loader.getController();
            beverageViewController.setMainController(this, this.primaryStage, this.primaryScene);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading beverage-view.fxml.");
            alert.setContentText("Couldn't load beverage-view.fxml.");
            alert.showAndWait();
        }
    }

    /**
     * Displays the cart view scene. Initializes the cart view if it hasn't been
     * initialized yet and refreshes the cart display.
     */
    @FXML
    protected void displayCartView() {
        if (this.cartScene == null) {
            initializeCartView();
        }
        this.primaryStage.setScene(this.cartScene);
        // Refresh the cart view if necessary
        this.cartViewController.refreshCartDisplay();
    }

    /**
     * Displays the order view scene. Initializes the cart view if it hasn't been
     * initialized yet.
     */
    @FXML
    protected void displayOrderView() {
        if (this.orderScene == null) {
            initializeOrderView();
        }
        this.primaryStage.setScene(this.orderScene);
    }

    /**
     * Set the reference of the stage and scene before show().
     *
     * @param stage the stage used to display the scene
     * @param scene the scene set to the stage
     */
    public void setPrimaryStage(Stage stage, Scene scene) {
        this.primaryStage = stage;
        this.primaryScene = scene;
    }

    /**
     * Initializes the cart view by loading the FXML file, creating the scene,
     * and setting up the controller. Displays an error alert if the FXML file
     * cannot be loaded.
     */
    public void initializeCartView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cart-view.fxml"));
            Parent root = loader.load();
            this.cartViewController = loader.getController();
            this.cartScene = new Scene(root);
            this.cartViewController.setMainController(this, this.primaryStage, this.primaryScene);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading cart-view.fxml.");
            alert.setContentText("Couldn't load cart-view.fxml.");
            alert.showAndWait();
        }
    }

    /**
     * Returns the controller for the cart view.
     *
     * @return the CartController instance for the cart view
     */
    public CartController getCartViewController() {
        return this.cartViewController;
    }

    /**
     * Initializes the order view by loading the FXML file, creating the scene,
     * and setting up the controller. Displays an error alert if the FXML file
     * cannot be loaded.
     */
    public void initializeOrderView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/order-view.fxml"));
            Parent root = loader.load();
            this.orderViewController = loader.getController();
            this.orderScene = new Scene(root);
            this.orderViewController.setMainController(this, this.primaryStage, this.primaryScene);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading order-view.fxml.");
            alert.setContentText("Couldn't load order-view.fxml.");
            alert.showAndWait();
        }
    }

    /**
     * Returns the controller for the order view.
     *
     * @return the OrderController instance for the order view
     */
    public OrderController getOrderViewController() {
        return this.orderViewController;
    }

    /**
     * Changes the burger button's background color to gold (#decb6b) when mouse enters.
     */
    @FXML
    public void mouseEnterBurger() {
        this.bt_burger.setStyle("-fx-background-color: #decb6b");
    }

    /**
     * Resets the burger button's background color to white (#FFFFFF) when mouse exits.
     */
    @FXML
    public void mouseExitBurger() {
        this.bt_burger.setStyle("-fx-background-color: #FFFFFF");
    }

    /**
     * Changes the sandwich button's background color to gold (#decb6b) when mouse enters.
     */
    @FXML
    public void mouseEnterSandwich() {
        this.bt_sandwich.setStyle("-fx-background-color: #decb6b");
    }

    /**
     * Resets the sandwich button's background color to white (#FFFFFF) when mouse exits.
     */
    @FXML
    public void mouseExitSandwich() {
        this.bt_sandwich.setStyle("-fx-background-color: #FFFFFF");
    }

    /**
     * Changes the beverage button's background color to gold (#decb6b) when mouse enters.
     */
    @FXML
    public void mouseEnterBeverage() {
        this.bt_beverage.setStyle("-fx-background-color: #decb6b");
    }

    /**
     * Resets the beverage button's background color to white (#FFFFFF) when mouse exits.
     */
    @FXML
    public void mouseExitBeverage() {
        this.bt_beverage.setStyle("-fx-background-color: #FFFFFF");
    }

    /**
     * Changes the side dish button's background color to gold (#decb6b) when mouse enters.
     */
    @FXML
    public void mouseEnterSide() {
        this.bt_side.setStyle("-fx-background-color: #decb6b");
    }

    /**
     * Resets the side dish button's background color to white (#FFFFFF) when mouse exits.
     */
    @FXML
    public void mouseExitSide() {
        this.bt_side.setStyle("-fx-background-color: #FFFFFF");
    }

    /**
     * Changes the cart button's background color to gold (#decb6b) when mouse enters.
     */
    @FXML
    public void mouseEnterCart() {
        this.bt_cart.setStyle("-fx-background-color: #decb6b");
    }

    /**
     * Resets the cart button's background color to white (#FFFFFF) when mouse exits.
     */
    @FXML
    public void mouseExitCart() {
        this.bt_cart.setStyle("-fx-background-color: #FFFFFF");
    }

    /**
     * Changes the order button's background color to gold (#decb6b) when mouse enters.
     */
    @FXML
    public void mouseEnterOrder() {
        this.bt_order.setStyle("-fx-background-color: #decb6b");
    }

    /**
     * Resets the order button's background color to white (#FFFFFF) when mouse exits.
     */
    @FXML
    public void mouseExitOrder() {
        this.bt_order.setStyle("-fx-background-color: #FFFFFF");
    }
}