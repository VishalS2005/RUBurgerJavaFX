package com.example.model;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Sandwich extends MenuItem {
    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    public final double ROAST_BEEF_PRICE = 10.99;

    public final double CHICKEN_PRICE = 8.99;

    public final double SALMON_PRICE = 9.99;

    protected Bread bread;
    protected Protein protein;
    protected ArrayList<AddOns> addOns;

    public Sandwich(Bread bread, Protein protein, ArrayList<AddOns> addOns, int quantity) {
       this.bread = bread;
       this.protein = protein;
       this.addOns = addOns;
       this.quantity = quantity;
    }

    @Override
    public double price() {
        return quantity * (basePrice() + priceOfAddOns());
    }

    public double basePrice() {
        return switch(protein) {
            case ROAST_BEEF -> ROAST_BEEF_PRICE;
            case CHICKEN -> CHICKEN_PRICE;
            case SALMON -> SALMON_PRICE;
            case BEEF_PATTY -> throw new IllegalStateException("Sandwich cannot have beef patty");
        };
    }

    public double priceOfAddOns() {
        double price = 0;
        for(AddOns addOn : addOns) {
           price += addOn.getPrice();
        }
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return  getIngredients() + "[" + formatter.format(price()) + "][" + quantity + "]";
    }

    public String getIngredients() {
        return "Sandwich[" + bread + ", " + protein + "]" + addOns.toString();
    }

    public static void main(String[] args) {
        ArrayList<AddOns> addOns = new ArrayList<>();
        addOns.add(AddOns.AVOCADO);
        Sandwich sandwich = new Sandwich(Bread.WHEAT_BREAD, Protein.SALMON, addOns, 2);
        System.out.println(sandwich);
    }
}
