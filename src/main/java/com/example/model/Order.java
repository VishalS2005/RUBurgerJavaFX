package com.example.model;

import java.util.ArrayList;

/**
 * The Order class holds a number to uniquely identify each order
 * and an ArrayList of MenuItems that represent the food/beverage the user
 * wants to order.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public class Order {

    /**
     * A unique integer to identify the order.
     */
    private int number;

    /**
     * An ArrayList of MenuItem objects that represent food/beverage items.
     */
    private ArrayList<MenuItem> items;

    /**
     * Used to represent the unique Order number.
     */
    private static int counter = 1;

    /**
     * Constructor for Order with the specified list of menu items.
     * The order number is automatically generated using counter.
     *
     * @param items the list of menu items included in this order
     */
    public Order(ArrayList<MenuItem> items) {
        this.number = counter++;
        this.items = items;
    }

    /**
     * Returns the unique order number for this order.
     *
     * @return the order number
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Returns the list of menu items in this order.
     *
     * @return the list of menu items
     */
    public ArrayList<MenuItem> getItems() {
        return this.items;
    }
}
