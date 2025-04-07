package com.example.model;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Represents a Sandwich MenuItem with bread, protein, and optional add-ons.
 * Calculates additional pricing based on protein and add-ons.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public class Sandwich extends MenuItem {

    /**
     * Currency formatter for US dollars.
     */
    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    /**
     * Price for roast beef sandwich .
     */
    public final double ROAST_BEEF_PRICE = 10.99;

    /**
     * Price for chicken sandwich.
     */
    public final double CHICKEN_PRICE = 8.99;

    /**
     * Price for salmon sandwich.
     */
    public final double SALMON_PRICE = 9.99;

    /**
     * Type of bread for this sandwich.
     */
    protected Bread bread;

    /**
     * Protein selection for this sandwich.
     */
    protected Protein protein;

    /**
     * List of additional toppings/add-ons.
     */
    protected ArrayList<AddOns> addOns;

    /**
     * Constructs a new Sandwich with specified components.
     *
     * @param bread type of bread
     * @param protein protein selection
     * @param addOns list of additional toppings
     * @param quantity amount of this sandwich ordered
     * @throws IllegalStateException if protein is BEEF_PATTY
     */
    public Sandwich(Bread bread, Protein protein, ArrayList<AddOns> addOns, int quantity) {
        this.bread = bread;
        this.protein = protein;
        this.addOns = addOns;
        this.quantity = quantity;
    }

    /**
     * Calculates the total price including quantity and add-ons.
     *
     * @return total price for this sandwich order
     */
    @Override
    public double price() {
        return quantity * (basePrice() + priceOfAddOns());
    }

    /**
     * Gets the base price based on protein selection.
     *
     * @return base price of the sandwich
     * @throws IllegalStateException if protein is BEEF_PATTY
     */
    public double basePrice() {
        return switch(protein) {
            case ROAST_BEEF -> ROAST_BEEF_PRICE;
            case CHICKEN -> CHICKEN_PRICE;
            case SALMON -> SALMON_PRICE;
            case BEEF_PATTY -> throw new IllegalStateException("Sandwich cannot have beef patty");
        };
    }

    /**
     * Calculates the total price of all add-ons.
     *
     * @return sum of all add-on prices
     */
    public double priceOfAddOns() {
        double price = 0;
        for(AddOns addOn : this.addOns) {
            price += addOn.getPrice();
        }
        return price;
    }

    /**
     * Gets the quantity of this sandwich ordered.
     *
     * @return number of sandwiches
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Returns a formatted string representation of the sandwich.
     * Format: "Sandwich[bread, protein][addons][total price][quantity]"
     *
     * @return formatted string with ingredients, price and quantity
     */
    @Override
    public String toString() {
        return getIngredients() + "[" + this.formatter.format(price()) + "][" + this.quantity + "]";
    }

    /**
     * Returns a string listing all sandwich ingredients.
     *
     * @return formatted string with bread, protein and add-ons
     */
    public String getIngredients() {
        return "Sandwich[" + this.bread + ", " + this.protein + "]" + this.addOns.toString();
    }
}
