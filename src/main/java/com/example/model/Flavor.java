package com.example.model;

/**
 * Represents available flavor options for beverages and other menu items.
 * Different flavors may affect the composition and pricing of items.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public enum Flavor {

    /**
     * Cola beverage.
     */
    COLA("Cola"),

    /**
     * Lime beverage.
     */
    LIME("Lime"),

    /**
     * Orange beverage.
     */
    ORANGE("Orange"),

    /**
     * Cherry beverage.
     */
    CHERRY("Cherry"),

    /**
     * Tea beverage.
     */
    TEA("Tea"),

    /**
     * Mango beverage.
     */
    MANGO("Mango"),

    /**
     * Strawberry beverage.
     */
    STRAWBERRY("Strawberry"),

    /**
     * Raspberry beverage.
     */
    RASPBERRY("Raspberry"),

    /**
     * Grape beverage.
     */
    GRAPE("Grape"),

    /**
     * Lemonade beverage.
     */
    LEMONADE("Lemonade"),

    /**
     * Smoothies beverage.
     */
    SMOOTHIES("Smoothies"),

    /**
     * Milk beverage.
     */
    MILK("Milk"),

    /**
     * Juice beverage.
     */
    JUICE("Juice"),

    /**
     * Water beverage.
     */
    WATER("Water"),

    /**
     * Coffee beverage.
     */
    COFFEE("Coffee");

    /**
     * The display name of the flavor.
     */
    public final String name;

    /**
     * Constructs a Flavor enum constant with specified display name.
     *
     * @param name the display name of the flavor
     */
    Flavor(String name) {
        this.name = name;
    }

    /**
     * Returns the display name of the flavor.
     *
     * @return the name of the flavor
     */
    @Override
    public String toString() {
        return name;
    }
}
