package com.example.controller;

import com.example.model.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * The ComboController class handles user interactions for creating and ordering a combo meal.
 * It manages UI elements such as combo boxes and text fields and
 * facilitates communication with other controllers like the CartController.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public class ComboController {

    /**
     * Formatter for displaying prices in US currency format.
     */
    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    /**
     * Reference to the MainController, used for communication with the main application.
     */
    private MainController mainController;

    /**
     * The primary stage of the application.
     */
    private Stage primaryStage;

    /**
     * The primary scene of the application, used for navigation between views.
     */
    private Scene primaryScene;

    /**
     * TextField to display the name of the selected sandwich.
     */
    @FXML
    private TextField tf_sandwich;

    /**
     * TextField to display the price of the selected sandwich or combo.
     */
    @FXML
    private TextField tf_price;

    /**
     * ComboBox for selecting a side item for the combo meal.
     */
    @FXML
    private ComboBox<Side> cb_sides;

    /**
     * ComboBox for selecting a beverage flavor for the combo meal.
     */
    @FXML
    private ComboBox<Flavor> cb_drinks;

    /**
     * ComboBox for selecting the quantity of combo meals to order.
     */
    @FXML
    private ComboBox<Integer> cb_quantity;

    /**
     * Represents the selected sandwich in the combo meal.
     */
    private Sandwich sandwich;

    @FXML
    private ImageView img_side;

    @FXML
    private ImageView img_drink;
    /**
     * Initializes the UI components with default values and populates combo boxes
     * with available options for sides, beverages, and quantities.
     */
    @FXML
    private void initialize() {
        ArrayList<Side> sides = new ArrayList<>();
        sides.add(Side.CHIPS);
        sides.add(Side.APPLE_SLICES);
        this.cb_sides.getItems().addAll(sides);
        this.cb_sides.setValue(Side.CHIPS);

        ArrayList<Flavor> flavors = new ArrayList<>();
        flavors.add(Flavor.COLA);
        flavors.add(Flavor.TEA);
        flavors.add(Flavor.JUICE);
        this.cb_drinks.getItems().addAll(flavors);
        this.cb_drinks.setValue(Flavor.COLA);

        this.cb_quantity.getItems().addAll(1, 2, 3, 4, 5);
        this.cb_quantity.setValue(1);
    }

    /**
     * Creates a Combo object based on the user's selections and adds the order to the cart.
     * Displays a confirmation alert after successfully adding the combo to the order.
     */
    @FXML
    private void addOrder() {
        Combo combo = new Combo(this.sandwich, getBeverage(), this.cb_sides.getValue(), this.cb_quantity.getValue());
        CartController cartController = this.mainController.getCartViewController();
        cartController.placeOrder(combo);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Ordering Combo");
        alert.setContentText("Combo added to order.");
        alert.showAndWait();
    }

    /**
     * Creates a Beverage object based on the selected drink flavor in the ComboBox.
     *
     * @return A Beverage object containing the selected flavor, or null if no valid flavor is selected.
     */
    private Beverage getBeverage() {
        if (this.cb_drinks.getValue() == Flavor.COLA) {
            return new Beverage(Size.MEDIUM, Flavor.COLA, 1);
        } else if (this.cb_drinks.getValue() == Flavor.TEA) {
            return new Beverage(Size.MEDIUM, Flavor.TEA, 1);
        } else if (this.cb_drinks.getValue() == Flavor.JUICE) {
            return new Beverage(Size.MEDIUM, Flavor.JUICE, 1);
        }
        return null;
    }

    /**
     * Sets the selected sandwich for the combo meal and updates the UI accordingly.
     * Prevents editing of the sandwich and price fields.
     *
     * @param sandwich The Sandwich object representing the selected sandwich.
     */
    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
        this.tf_sandwich.setText(sandwich.getIngredients());
        refresh();
        this.tf_price.setEditable(false);
        this.tf_price.setFocusTraversable(false);
        this.tf_sandwich.setEditable(false);
        this.tf_sandwich.setFocusTraversable(false);
    }

    /**
     * Refreshes the UI by updating the displayed price of the combo meal.
     * Calculates the price based on the current combo settings.
     */
    @FXML
    public void refresh() {
        double price = new Combo(this.sandwich, getBeverage(), this.cb_sides.getValue(), this.cb_quantity.getValue()).price();
        this.tf_price.setText(formatter.format(price));

        Image side = switch (cb_sides.getValue()) {
            case CHIPS -> new Image(getClass().getResource("/image/Chips.jpg").toExternalForm());
            case APPLE_SLICES -> new Image(getClass().getResource("/image/Apple Slices.png").toExternalForm());
            default -> null;
        };

        if (side != null) {
            img_side.setImage(side);
        }


        Image drink = switch (cb_drinks.getValue()) {
            case COLA-> new Image(getClass().getResource("/image/Soda.jpg").toExternalForm());
            case TEA -> new Image(getClass().getResource("/image/Tea.png").toExternalForm());
            case JUICE -> new Image(getClass().getResource("/image/Juice.png").toExternalForm());
            default -> null;
        };

        if (drink != null) {
            img_drink.setImage(drink);
        }
    }


    /**
     * Sets the reference to the MainController, primary stage, and primary scene.
     * Allows interaction with the MainController's public methods and facilitates scene navigation.
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
     * Navigates back to the main view by displaying the primary scene on the primary stage.
     */
    @FXML
    public void displayMain() {
        this.primaryStage.setScene(primaryScene);
        this.primaryStage.show();
    }
}

