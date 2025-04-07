package com.example.model;

/**
 * Represents available protein options for menu items.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public enum Protein {

    /**
     * Roast beef protein option.
     */
    ROAST_BEEF("Roast Beef"),

    /**
     * Salmon protein option.
     */
    SALMON("Salmon"),

    /**
     * Chicken protein option.
     */
    CHICKEN("Chicken"),

    /**
     * Beef patty protein option (typically for Burger).
     */
    BEEF_PATTY("Beef Patty");

    /**
     * The display name of the protein.
     */
    private final String name;

    /**
     * Constructs a Protein enum constant with specified display name.
     *
     * @param name the display name of the protein
     */
    Protein(String name) {
        this.name = name;
    }

    /**
     * Returns the display name of the protein.
     *
     * @return the String name of the protein
     */
    @Override
    public String toString() {
        return this.name;
    }
}
