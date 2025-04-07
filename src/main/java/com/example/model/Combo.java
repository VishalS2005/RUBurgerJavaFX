package com.example.model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Combo extends MenuItem{
    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
    public static final double COMBO_RATE = 2;
    private Sandwich sandwich;
    private Beverage drink;
    private Side side;

    public Combo(Sandwich sandwich, Beverage drink, Side side, int quantity) {
        this.sandwich = sandwich;
        this.drink = drink;
        this.side = side;
        this.quantity = quantity;
    }

    @Override
    public double price() {
        return quantity * (sandwich.price() + COMBO_RATE);
    }

    @Override
    public String toString() {
        return "Combo[" + quantity + "]" + sandwich.getIngredients() + "[" + drink.getIngredients() + ", " + side + "]" + formatter.format(price());
    }

    public static void main(String[] args) {

        ArrayList<AddOns> addOns = new ArrayList<>();
        addOns.add(AddOns.LETTUCE);
        addOns.add(AddOns.TOMATOES);
        addOns.add(AddOns.ONIONS);
        Burger burger = new Burger(Bread.BRIOCHE, false, addOns, 1);
        Combo combo = new Combo(burger, new Beverage(Size.MEDIUM, Flavor.TEA, 1), Side.APPLE_SLICES, 1);
        System.out.println(combo);
    }
}
