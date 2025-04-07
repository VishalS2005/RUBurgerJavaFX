package com.example.model;

/**
 * Represents available size options for menu items.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public enum Size {

    /**
     * Small size option.
     */
    SMALL("Small"),

    /**
     * Medium size option.
     */
    MEDIUM("Medium"),

    /**
     * Large size option.
     */
    LARGE("Large");

    /**
     * The display name of the size.
     */
    private final String name;

    /**
     * Constructs a Size enum constant with given display name.
     *
     * @param name the display name of the size
     */
    Size(String name) {
        this.name = name;
    }

    /**
     * Returns the display name of the size.
     *
     * @return the String name of the size
     */
    @Override
    public String toString() {
        return this.name;
    }
}
