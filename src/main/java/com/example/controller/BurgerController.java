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

/**
 * The BurgerController class manages the user interface for customizing a burger.
 * It handles user interactions with UI components such as
 * combo boxes, radio buttons, and checkboxes, and calculates the price of the selected burger.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public class BurgerController {

    /**
     * Formatter to display currency in US locale format.
     */
    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    /**
     * Reference to the MainController, used to communicate with the main application.
     */
    private MainController mainController;

    /**
     * The primary stage of the application.
     */
    private Stage primaryStage;

    /**
     * The primary scene of the application, used to navigate back to the main view.
     */
    private Scene primaryScene;

    /**
     * ComboBox to select the quantity of burgers.
     */
    @FXML
    private ComboBox<Integer> cb_quantity;

    /**
     * RadioButton to select a single patty option.
     */
    @FXML
    private RadioButton rb_single;

    /**
     * RadioButton to select a double patty option.
     */
    @FXML
    private RadioButton rb_double;

    /**
     * RadioButton to select brioche bread for the burger.
     */
    @FXML
    private RadioButton rb_brioche;

    /**
     * RadioButton to select wheat bread for the burger.
     */
    @FXML
    private RadioButton rb_wheat;

    /**
     * RadioButton to select pretzel bread for the burger.
     */
    @FXML
    private RadioButton rb_pretzel;

    /**
     * CheckBox to include lettuce as a topping.
     */
    @FXML
    private CheckBox cb_lettuce;

    /**
     * CheckBox to include tomato as a topping.
     */
    @FXML
    private CheckBox cb_tomato;

    /**
     * CheckBox to include onion as a topping.
     */
    @FXML
    private CheckBox cb_onion;

    /**
     * CheckBox to include avocado as a topping.
     */
    @FXML
    private CheckBox cb_avocado;

    /**
     * CheckBox to include cheese as a topping.
     */
    @FXML
    private CheckBox cb_cheese;

    /**
     * TextField to display the calculated price of the burger.
     */
    @FXML
    private TextField tf_price;

    /**
     * Handles the event of the image button being clicked.
     * Loads a new window with the scene graph defined in combo-view.fxml and passes data
     * to the ComboController for burger customization.
     */
    @FXML
    protected void comboOnClick() {
        BorderPane root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/combo-view.fxml"));
            root = (BorderPane) loader.load();
            Scene scene = new Scene(root, 600, 524);
            this.primaryStage.setScene(scene);

            ComboController comboViewController = loader.getController();
            Burger burger = getBurger();
            burger.setQuantity(1);
            comboViewController.setSandwich(burger);
            comboViewController.setMainController(this.mainController, this.primaryStage, this.primaryScene);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading combo-view.fxml.");
            alert.setContentText("Couldn't load combo-view.fxml.");
            alert.showAndWait();
        }
    }

    /**
     * Initializes the UI components for the BurgerController.
     * Sets default values and ensures certain elements are not editable.
     */
    @FXML
    private void initialize() {
        this.cb_quantity.getItems().addAll(1, 2, 3, 4, 5);
        this.cb_quantity.setValue(1);
        this.cb_quantity.setVisibleRowCount(5);
        this.rb_single.setSelected(true);
        this.rb_brioche.setSelected(true);
        this.tf_price.setEditable(false);
        this.tf_price.setFocusTraversable(false);
        setPrice();
    }

    /**
     * Updates the price of the burger based on the selected options and displays it in the UI.
     */
    @FXML
    private void setPrice() {
        Burger burger = getBurger();
        this.tf_price.setText(formatter.format(burger.price()));
    }

    /**
     * Creates a Burger object based on the user's selections.
     *
     * @return A Burger object containing the selected bread, patty type, add-ons, and quantity.
     */
    private Burger getBurger() {
        boolean isDoublePatty = this.rb_double.isSelected();
        Bread bread = getBread();
        ArrayList<AddOns> addOns = getAddOns();
        int quantity = this.cb_quantity.getValue();
        return new Burger(bread, isDoublePatty, addOns, quantity);
    }

    /**
     * Generates a list of selected add-ons based on the state of the checkboxes.
     *
     * @return A list of AddOns selected by the user.
     */
    private ArrayList<AddOns> getAddOns() {
        ArrayList<AddOns> addOns = new ArrayList<>();

        if (this.cb_lettuce.isSelected()) {
            addOns.add(AddOns.LETTUCE);
        }
        if (this.cb_tomato.isSelected()) {
            addOns.add(AddOns.TOMATOES);
        }
        if (this.cb_onion.isSelected()) {
            addOns.add(AddOns.ONIONS);
        }
        if (this.cb_avocado.isSelected()) {
            addOns.add(AddOns.AVOCADO);
        }
        if (this.cb_cheese.isSelected()) {
            addOns.add(AddOns.CHEESE);
        }

        return addOns;
    }

    /**
     * Determines the bread type for the burger based on the selected radio button.
     *
     * @return A Bread enum representing the selected bread type.
     */
    private Bread getBread() {
        if (this.rb_brioche.isSelected()) {
            return Bread.BRIOCHE;
        } else if (this.rb_wheat.isSelected()) {
            return Bread.WHEAT_BREAD;
        } else if (this.rb_pretzel.isSelected()) {
            return Bread.PRETZEL;
        }
        return null;
    }

    /**
     * Handles the event of the order button being clicked.
     * Places the burger order in the CartController and displays a confirmation alert.
     */
    @FXML
    private void orderOnClick() {
        CartController cartController = this.mainController.getCartViewController();
        cartController.placeOrder(getBurger());

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Ordering Burger");
        alert.setContentText("Burger added to order.");
        alert.showAndWait();
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
     * Navigates back to the main view by displaying the primary scene on the primary stage.
     */
    @FXML
    public void displayMain() {
        this.primaryStage.setScene(this.primaryScene);
        this.primaryStage.show();
    }
}
