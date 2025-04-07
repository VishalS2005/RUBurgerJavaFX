package com.example.model;

/**
 * Represents available bread types for sandwiches and other menu items.
 * Different bread types may affect the taste and composition of items.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public enum Bread {

    /**
     * Brioche bread.
     */
    BRIOCHE("Brioche"),

    /**
     * Whole wheat bread.
     */
    WHEAT_BREAD("Wheat"),

    /**
     * Pretzel bread.
     */
    PRETZEL("Pretzel"),

    /**
     * Bagel bread.
     */
    BAGEL("Bagel"),

    /**
     * Sourdough bread.
     */
    SOURDOUGH("Sourdough");

    /**
     * The display name of the bread type
     */
    private final String name;

    /**
     * Constructs a Bread enum constant with specified display name.
     *
     * @param name the display name of the bread type
     */
    Bread(String name) {
        this.name = name;
    }

    /**
     * Returns the display name of the bread type.
     *
     * @return the String name of the bread type
     */
    @Override
    public String toString() {
        return this.name;
    }
}

