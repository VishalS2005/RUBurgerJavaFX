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

/**
 * The SandwichController class manages the user interface for customizing sandwiches.
 * It handles user interactions with various UI elements
 * such as radio buttons, combo boxes, and checkboxes, and calculates the sandwich price.
 *
 * @author Vishal Saravnanan, Yining Chen
 */
public class SandwichController {

    /**
     * Formatter for displaying currency in US locale format.
     */
    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

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
     * RadioButton for selecting roast beef as the sandwich protein.
     */
    @FXML
    private RadioButton rb_roastBeef;

    /**
     * RadioButton for selecting salmon as the sandwich protein.
     */
    @FXML
    private RadioButton rb_salmon;

    /**
     * RadioButton for selecting chicken as the sandwich protein.
     */
    @FXML
    private RadioButton rb_chicken;

    /**
     * ComboBox for selecting the quantity of sandwiches to order.
     */
    @FXML
    private ComboBox<Integer> cb_quantity;

    /**
     * CheckBox for including lettuce as a topping.
     */
    @FXML
    private CheckBox cb_lettuce;

    /**
     * CheckBox for including tomato as a topping.
     */
    @FXML
    private CheckBox cb_tomato;

    /**
     * CheckBox for including onion as a topping.
     */
    @FXML
    private CheckBox cb_onion;

    /**
     * CheckBox for including avocado as a topping.
     */
    @FXML
    private CheckBox cb_avocado;

    /**
     * CheckBox for including cheese as a topping.
     */
    @FXML
    private CheckBox cb_cheese;

    /**
     * TextField for displaying the price of the selected sandwich configuration.
     * This field is non-editable.
     */
    @FXML
    private TextField tf_price;

    /**
     * ComboBox for selecting the type of bread for the sandwich.
     */
    @FXML
    private ComboBox<Bread> cb_bread;

    /**
     * Handles the event triggered by clicking the image button.
     * Opens a new window with the scene defined in combo-view.fxml and passes data
     * to the ComboController for managing sandwich details.
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
            Sandwich sandwich = getSandwich();
            sandwich.setQuantity(1);
            comboViewController.setSandwich(sandwich);
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
     * Initializes the UI components for the SandwichController.
     * Sets default values for combo boxes and ensures certain fields are non-editable.
     */
    @FXML
    private void initialize() {
        this.cb_quantity.getItems().addAll(1, 2, 3, 4, 5);
        this.cb_quantity.setValue(1);
        this.cb_quantity.setVisibleRowCount(5);

        this.cb_bread.getItems().addAll(Bread.values());
        this.cb_bread.setValue(Bread.BRIOCHE);

        this.rb_roastBeef.setSelected(true);

        this.tf_price.setEditable(false);
        this.tf_price.setFocusTraversable(false);

        setPrice();
    }

    /**
     * Updates the price of the sandwich based on the current selections
     * and displays it in the TextField.
     */
    @FXML
    private void setPrice() {
        Sandwich sandwich = getSandwich();
        this.tf_price.setText(formatter.format(sandwich.price()));
    }

    /**
     * Retrieves the type of bread selected in the ComboBox.
     *
     * @return The selected Bread type.
     */
    private Bread getBread() {
        return this.cb_bread.getValue();
    }

    /**
     * Determines the type of protein selected based on the selected RadioButton.
     *
     * @return The selected Protein type, or null if none is selected.
     */
    private Protein getProtein() {
        if (this.rb_roastBeef.isSelected()) {
            return Protein.ROAST_BEEF;
        } else if (this.rb_salmon.isSelected()) {
            return Protein.SALMON;
        } else if (this.rb_chicken.isSelected()) {
            return Protein.CHICKEN;
        }
        return null;
    }

    /**
     * Constructs a Sandwich object based on the selected bread, protein, add-ons, and quantity.
     *
     * @return A Sandwich object reflecting the user's selections.
     */
    private Sandwich getSandwich() {
        Bread bread = getBread();
        Protein protein = getProtein();
        ArrayList<AddOns> addOns = getAddOns();
        int quantity = this.cb_quantity.getValue();
        return new Sandwich(bread, protein, addOns, quantity);
    }

    /**
     * Retrieves the selected add-ons from the checkboxes.
     *
     * @return A list of selected AddOns.
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
     * Places the currently selected sandwich into the CartController and displays a confirmation.
     */
    @FXML
    private void orderOnClick() {
        CartController cartController = this.mainController.getCartViewController();
        cartController.placeOrder(getSandwich());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Ordering Sandwich");
        alert.setContentText("Sandwich added to order.");
        alert.showAndWait();
    }

    /**
     * Sets the reference to the MainController, primary stage, and primary scene.
     * This enables interaction with the MainController's public methods and scene navigation.
     *
     * @param controller   The MainController object reference.
     * @param primaryStage The primary stage of the application.
     * @param primaryScene The primary scene to navigate back to.
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
        this.primaryStage.setScene(primaryScene);
        this.primaryStage.show();
    }
}
