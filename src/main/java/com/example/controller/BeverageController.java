package com.example.controller;

import com.example.model.Beverage;
import com.example.model.Flavor;
import com.example.model.Size;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Controller class for handling beverage selection and ordering functionality.
 * Manages user interactions with beverage flavors, sizes, quantities, and pricing.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public class BeverageController {

    /**
     * Formatter for displaying currency values in US format.
     */
    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    /**
     * Reference to the main application controller.
     */
    private MainController mainController;

    /**
     * Reference to the primary application stage.
     */
    private Stage primaryStage;

    /**
     * Reference to the primary application scene.
     */
    private Scene primaryScene;

    /**
     * Text field displaying the current beverage price.
     */
    @FXML
    private TextField tf_price;

    /**
     * ComboBox for selecting beverage size.
     */
    @FXML
    private ComboBox<Size> cb_size;

    /**
     * ComboBox for selecting beverage quantity.
     */
    @FXML
    private ComboBox<Integer> cb_quantity;

    /**
     * ListView displaying available beverage flavors.
     */
    @FXML
    public ListView<Flavor> lv_flavors;

    /**
     * Initializes the controller class. This method is automatically called
     * after the FXML file has been loaded. Sets up default values for:
     * Quantity selection (1-5);
     * Available sizes (from Size enum);
     * Available flavors (from Flavor enum);
     * Default selections (Medium size, quantity 1, first flavor)
     */
    @FXML
    private void initialize() {
        this.cb_quantity.getItems().addAll(1, 2, 3, 4, 5);
        this.cb_quantity.setVisibleRowCount(5);
        this.cb_size.getItems().addAll(Size.values());
        this.lv_flavors.getItems().addAll(Flavor.values());
        this.tf_price.setEditable(false);
        this.tf_price.setFocusTraversable(false);
        this.cb_size.setValue(Size.MEDIUM);
        this.cb_quantity.setValue(1);
        this.lv_flavors.getSelectionModel().select(0);
        setPrice();
    }

    /**
     * Updates the price display based on current beverage selection.
     */
    @FXML
    private void setPrice() {
        Beverage beverage = getBeverage();
        this.tf_price.setText(this.formatter.format(beverage.price()));
    }

    /**
     * Creates a new Beverage object based on current selections.
     *
     * @return Beverage object with selected size, flavor and quantity
     */
    @FXML
    private Beverage getBeverage() {
        return new Beverage(this.cb_size.getValue(),
                this.lv_flavors.getSelectionModel().getSelectedItem(),
                this.cb_quantity.getValue());
    }

    /**
     * Handles the order button click event. Validates selection and adds
     * the beverage to the cart. Displays confirmation or error messages.
     */
    @FXML
    private void orderOnClick() {
        if(this.lv_flavors.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Please Select a Flavor");
            alert.showAndWait();
            return;
        }
        CartController cartController = this.mainController.getCartViewController();
        cartController.placeOrder(getBeverage());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Ordering Beverage");
        alert.setContentText("Beverage added to order.");
        alert.showAndWait();
    }

    /**
     * Sets the reference to the main controller and primary stage/scene.
     *
     * @param controller The main application controller
     * @param primaryStage The primary application stage
     * @param primaryScene The primary application scene
     */
    public void setMainController(MainController controller,
                                  Stage primaryStage,
                                  Scene primaryScene) {
        this.mainController = controller;
        this.primaryStage = primaryStage;
        this.primaryScene = primaryScene;
    }

    /**
     * Returns to the main application view.
     */
    @FXML
    public void displayMain() {
        this.primaryStage.setScene(this.primaryScene);
        this.primaryStage.show();
    }
}
