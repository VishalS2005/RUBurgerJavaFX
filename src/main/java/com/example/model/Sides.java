package com.example.model;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Represents a side dish menu item with customizable size and quantity.
 * The price is determined by the specific side dish and its size.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public class Sides extends MenuItem {

    /**
     * Currency formatter for US dollars.
     */
    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    /**
     * The type of side dish (chips, fries, onion rings, etc.).
     */
    private Side side;

    /**
     * The size of the side dish (SMALL, MEDIUM, LARGE).
     */
    private Size size;

    /**
     * Constructs a new Sides menu item.
     *
     * @param side the type of side dish
     * @param size the size of the side dish
     * @param quantity the number of side dish items ordered
     */
    public Sides(Side side, Size size, int quantity) {
        this.side = side;
        this.size = size;
        this.quantity = quantity;
    }

    /**
     * Returns a formatted string representation of the side dish.
     * Format: "[side], [size][quantity][formatted price]"
     *
     * @return formatted String with side details and price
     */
    @Override
    public String toString() {
        return this.side + ", " + this.size + "[" + this.quantity + "]" + this.formatter.format(price());
    }

    /**
     * Calculates the total price based on side dish type, size, and quantity.
     *
     * @return total price for the side dish order
     */
    @Override
    public double price() {
        return this.quantity * this.side.getPrice(this.size);
    }
}
