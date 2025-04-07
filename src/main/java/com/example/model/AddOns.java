package com.example.model;

/**
 * Represents additional toppings/add-ons that can be included with menu items.
 * Each add-on has an associated price that affects the total cost.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public enum AddOns {

    /**
     * Lettuce add-on ($0.30)
     */
    LETTUCE("Lettuce", 0.3),

    /**
     * Tomatoes add-on ($0.30).
     */
    TOMATOES("Tomatoes", 0.3),

    /**
     * Onions add-on ($0.30).
     */
    ONIONS("Onions", 0.3),

    /**
     * Avocado add-on ($0.50).
     */
    AVOCADO("Avocado", 0.5),

    /**
     * Cheese add-on ($1.00).
     */
    CHEESE("Cheese", 1.0);

    /**
     * The display name of the add-on.
     */
    private final String name;

    /**
     * The additional price for this add-on.
     */
    private final double price;

    /**
     * Constructs an AddOns enum constant with specified name and price.
     *
     * @param name the display name of the add-on
     * @param price the additional cost for this add-on
     */
    AddOns(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the additional price for this add-on.
     *
     * @return the price of the add-on
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the display name of the add-on.
     *
     * @return the String name of the add-on
     */
    @Override
    public String toString() {
        return this.name;
    }
}
