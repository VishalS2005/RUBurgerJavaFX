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

public class BeverageController {

    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);


    private MainController mainController;

    private Stage stage;

    private Scene primaryScene;

    private Stage primaryStage;

    @FXML
    private TextField tf_price;

    @FXML
    public ListView<Flavor> lv_flavors;

    @FXML
    private ComboBox<Size> cb_size;

    @FXML
    private ComboBox<Integer> cb_quantity;

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
    private void initialize() {
        cb_quantity.getItems().addAll(1, 2, 3, 4, 5);
        cb_quantity.setVisibleRowCount(5);
        cb_size.getItems().addAll(Size.values());
        lv_flavors.getItems().addAll(Flavor.values());
        tf_price.setEditable(false);
        tf_price.setFocusTraversable(false);
        cb_size.setValue(Size.SMALL);
        cb_quantity.setValue(1);
        setPrice();
    }

    @FXML
    private void setPrice() {
        Beverage beverage = getBeverage();
        tf_price.setText(formatter.format(beverage.price()));
    }

    @FXML
    private Beverage getBeverage() {
        return new Beverage(cb_size.getValue(), lv_flavors.getSelectionModel().getSelectedItem(), cb_quantity.getValue());
    }

    @FXML
    public void displayMain() {
        //stage.close(); //close the window.
        this.primaryStage.setScene(primaryScene);
        this.primaryStage.show();
    }


    @FXML
    private void orderOnClick() {
        if(lv_flavors.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Please Select a Flavor");
            alert.showAndWait();
            return;
        }
        CartController cartController = mainController.getCartViewController();
        cartController.placeOrder(getBeverage());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Ordering Beverage");
        alert.setContentText("Beverage added to order.");
        alert.showAndWait();
    }

}
