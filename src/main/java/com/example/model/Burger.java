package com.example.model;


import java.util.ArrayList;

public class Burger extends Sandwich {
    public final double DOUBLE_PATTY_PRICE = 9.49;

    public final double SINGLE_PATTY_PRICE = 6.99;

    private final boolean doublePatty;

    public Burger(Bread bread, boolean doublePatty, ArrayList<AddOns> addOns, int quantity) {
        super(bread, Protein.BEEF_PATTY, addOns, quantity);
        this.doublePatty = doublePatty;
    }
    @Override
    public double price() {
       return quantity * (priceOfAddOns() + basePrice());
    }

    @Override
    public double basePrice() {
        return (doublePatty ?  DOUBLE_PATTY_PRICE : SINGLE_PATTY_PRICE);
    }

    @Override
    public String getClassName() {
        return "Burger";
    }

    public static void main(String[] args) {

        ArrayList<AddOns> addOns = new ArrayList<>();
        addOns.add(AddOns.CHEESE);
        addOns.add(AddOns.AVOCADO);
        Burger burger = new Burger(Bread.BRIOCHE, true, addOns, 1);
        System.out.println(burger);
    }
}
