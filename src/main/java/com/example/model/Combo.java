package com.example.model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Represents a combo meal consisting of a sandwich, beverage, and side.
 * Combos receive a special rate discount applied to the sandwich price.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public class Combo extends MenuItem {

    /**
     * Currency formatter for US dollars.
     */
    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    /**
     * Special rate discount applied to combos ($2 off total price).
     */
    public static final double COMBO_RATE = 2;

    /**
     * The sandwich included in this combo.
     */
    private Sandwich sandwich;

    /**
     * The beverage included in this combo.
     */
    private Beverage drink;

    /**
     * The side dish included in this combo.
     */
    private Side side;

    /**
     * Constructs a new Combo meal with specified components.
     *
     * @param sandwich the sandwich included in the combo
     * @param drink the beverage included in the combo
     * @param side the side dish included in the combo
     * @param quantity the number of combo meals ordered
     */
    public Combo(Sandwich sandwich, Beverage drink, Side side, int quantity) {
        this.sandwich = sandwich;
        this.drink = drink;
        this.side = side;
        this.quantity = quantity;
    }

    /**
     * Calculates the total price for the combo meal.
     * Applies the combo rate discount to the sandwich price.
     * Note: Beverage and side prices are not included in the combo price.
     *
     * @return total price for the combo order
     */
    @Override
    public double price() {
        return this.quantity * (this.sandwich.price() + COMBO_RATE);
    }

    /**
     * Returns a formatted string representation of the combo meal.
     * Format: "Combo[quantity][Sandwich ingredients][Beverage, Side][total price]"
     * Example: "Combo[1][Sandwich[WHEAT_BREAD, SALMON][AVOCADO]][COLA, SMALL, ONION_RINGS]$12.99"
     *
     * @return formatted string with combo details and price
     */
    @Override
    public String toString() {
        return "Combo[" + this.quantity + "]" + this.sandwich.getIngredients()
                + "[" + this.drink.getIngredients() + ", " + this.side + "]"
                + this.formatter.format(price());
    }
}
