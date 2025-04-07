package com.example.model;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Represents a beverage menu item with size and flavor options.
 * The price is determined by the size of the beverage.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public class Beverage extends MenuItem {

    /**
     * Currency formatter for US dollars.
     */
    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    /**
     * Price for small size beverage.
     */
    public final double SMALL_PRICE = 1.99;

    /**
     * Price for medium size beverage.
     */
    public final double MEDIUM_PRICE = 2.49;

    /**
     * Price for large size beverage.
     */
    public final double LARGE_PRICE = 2.99;

    /**
     * The size of the beverage (SMALL, MEDIUM, or LARGE).
     */
    private Size size;

    /**
     * The flavor of the beverage.
     */
    private Flavor flavor;

    /**
     * Constructs a new Beverage with specified size, flavor and quantity.
     *
     * @param size the size of the beverage (SMALL, MEDIUM, or LARGE)
     * @param flavor the flavor of the beverage
     * @param quantity the number of beverages ordered
     */
    public Beverage(Size size, Flavor flavor, int quantity) {
        this.size = size;
        this.flavor = flavor;
        this.quantity = quantity;
    }

    /**
     * Calculates the total price based on beverage size and quantity.
     *
     * @return total price for the beverage order
     */
    @Override
    public double price() {
        return quantity * switch(size) {
            case SMALL -> SMALL_PRICE;
            case MEDIUM -> MEDIUM_PRICE;
            case LARGE  -> LARGE_PRICE;
        };
    }

    /**
     * Returns a formatted string representation of the beverage.
     * Format: "[flavor], [size] [formatted price][quantity]"
     *
     * @return formatted string with flavor, size, price and quantity
     */
    @Override
    public String toString() {
        return getIngredients() + " " + this.formatter.format(price()) + "[" + this.quantity + "]";
    }

    /**
     * Returns a string listing the beverage's flavor and size.
     * Format: "[flavor], [size]"
     *
     * @return formatted string with flavor and size
     */
    public String getIngredients() {
        return this.flavor + ", " + this.size;
    }
}
