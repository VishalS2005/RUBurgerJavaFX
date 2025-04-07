package com.example.model;


import java.util.ArrayList;

/**
 * Represents a Burger MenuItem that extends Sandwich.
 * A burger has either a single or double beef patty with add-ons.
 * Price is calculated based on patty size and additional toppings.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public class Burger extends Sandwich {

    /**
     * Price for a burger with double patty
     */
    public final double DOUBLE_PATTY_PRICE = 9.49;

    /**
     * Price for a burger with single patty
     */
    public final double SINGLE_PATTY_PRICE = 6.99;

    /**
     * Flag indicating if this burger has a double patty
     */
    private final boolean doublePatty;

    /**
     * Constructs a new Burger with specified components.
     *
     * @param bread the type of bread for the burger
     * @param doublePatty true for double patty, false for single
     * @param addOns list of additional toppings
     * @param quantity number of burgers ordered
     */
    public Burger(Bread bread, boolean doublePatty, ArrayList<AddOns> addOns, int quantity) {
        super(bread, Protein.BEEF_PATTY, addOns, quantity);
        this.doublePatty = doublePatty;
    }

    /**
     * Calculates the total price including quantity and add-ons.
     *
     * @return total price for this burger order
     */
    @Override
    public double price() {
        return this.quantity * (priceOfAddOns() + basePrice());
    }

    /**
     * Gets the base price based on patty size (single or double).
     *
     * @return base price of the burger
     */
    @Override
    public double basePrice() {
        return (this.doublePatty ? this.DOUBLE_PATTY_PRICE : this.SINGLE_PATTY_PRICE);
    }

    /**
     * Returns a formatted string representation of the burger.
     * Format: "Burger, [single|double][bread][addons][total price][quantity]"
     *
     * @return formatted string with ingredients, price and quantity
     */
    @Override
    public String toString() {
        return getIngredients() + "[" + this.formatter.format(price()) + "][" + this.quantity + "]";
    }

    /**
     * Returns a string listing all burger ingredients.
     * Format: "Burger, [single|double][bread][addons]"
     *
     * @return formatted string with patty size, bread and add-ons
     */
    @Override
    public String getIngredients() {
        return "Burger, " + (this.doublePatty? "double[" : "single[") + this.bread + "]" + this.addOns.toString();
    }
}
