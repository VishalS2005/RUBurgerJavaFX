package com.example.model;

public class Beverage extends MenuItem {
    public final double SMALL_PRICE = 1.99;

    public final double MEDIUM_PRICE = 2.49;

    public final double LARGE_PRICE = 2.99;

    private Size size;
    private Flavor flavor;

    @Override
    public double price() {
        return switch(size) {
            case SMALL -> SMALL_PRICE;
            case MEDIUM -> MEDIUM_PRICE;
            case LARGE  -> LARGE_PRICE;
        };
    }
}
