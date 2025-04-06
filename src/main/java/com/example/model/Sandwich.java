package com.example.model;


import java.util.ArrayList;

public class Sandwich extends MenuItem {
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
}
