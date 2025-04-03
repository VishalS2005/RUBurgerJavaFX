package com.example.model;

public class Combo extends MenuItem{
    public final double COMBO_RATE = 2;
    private Sandwich sandwich;
    private Beverage drink;
    private Side side;

    @Override
    public double price() {
        return sandwich.price() + COMBO_RATE;
    }
}
