package com.example.model;

public class Combo extends MenuItem{
    public static final double COMBO_RATE = 2;
    private Sandwich sandwich;
    private Beverage drink;
    private Side side;

    public Combo(Sandwich sandwich, Beverage drink, Side side) {
        this.sandwich = sandwich;
        this.drink = drink;
        this.side = side;
    }

    @Override
    public double price() {
        return quantity * (sandwich.price() + COMBO_RATE);
    }
}
