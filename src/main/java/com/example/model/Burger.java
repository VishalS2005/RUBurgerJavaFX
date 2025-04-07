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
    public String toString() {
        return  getIngredients() + "[" + formatter.format(price()) + "][" + quantity + "]";
    }

    @Override
    public String getIngredients() {
        return "Burger, " + (doublePatty? "double[" : "single[") + bread + "]" +  addOns.toString();
    }

    public static void main(String[] args) {

        ArrayList<AddOns> addOns = new ArrayList<>();
        addOns.add(AddOns.LETTUCE);
        addOns.add(AddOns.TOMATOES);
        addOns.add(AddOns.CHEESE);
        Burger burger = new Burger(Bread.WHEAT_BREAD, true, addOns, 2);
        System.out.println(burger);
    }
}
