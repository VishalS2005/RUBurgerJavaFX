package com.example.model;

/**
 * Represents side dish options available for meals.
 * Each side has a base price that can be modified by size selection.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public enum Side {

    /**
     * Chips side dish with base price of $1.99.
     */
    CHIPS("Chips", 1.99),

    /**
     * Fries side dish with base price of $2.49.
     */
    FRIES("Fries", 2.49),

    /**
     * Onion rings side dish with base price of $3.29.
     */
    ONION_RINGS("Onion Rings", 3.29),

    /**
     * Apple slices side dish with base price of $1.29.
     */
    APPLE_SLICES("Apple Slices", 1.29);

    /**
     * The display name of the side dish.
     */
    private final String name;

    /**
     * The base price of the side dish.
     */
    private final double price;

    /**
     * Constructs a Side enum constant with specified name and base price.
     *
     * @param name the display name of the side dish
     * @param price the base price of the side dish
     */
    Side(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Calculates the final price of the side dish based on selected size.
     * Size modifications:
     *   SMALL: base price (no change);
     *   MEDIUM: base price + $0.50;
     *   LARGE: base price + $1.00
     *
     * @param size the selected size of the side dish
     * @return the final price after size adjustment
     */
    public double getPrice(Size size) {
        return price + switch(size) {
            case SMALL -> 0;
            case MEDIUM -> 0.5;
            case LARGE -> 1;
        };
    }

    /**
     * Returns the display name of the side dish.
     *
     * @return the String name of the side dish
     */
    @Override
    public String toString() {
        return this.name;
    }
}
