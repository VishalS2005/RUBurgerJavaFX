package com.example.model;

/**
 * Abstract class that represents a food/beverage item in our restaurant
 *
 * @author Vishal Saravanan, Yining Chen
 */
public abstract class MenuItem {

    /**
     * The quantity of this MenuItem.
     */
    protected int quantity;

    /**
     * Calculates the total price for this MenuItem.
     *
     * @return the total price of the menu item, typically quantity multiplied by unit price
     */
    public abstract double price();

    /**
     * Sets the quantity of this MenuItem.
     *
     * @param quantity the number of units of this menu item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}