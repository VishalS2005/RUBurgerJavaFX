package com.example.model;

import java.text.NumberFormat;
import java.util.Locale;

public class Beverage extends MenuItem {
    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

    public final double SMALL_PRICE = 1.99;

    public final double MEDIUM_PRICE = 2.49;

    public final double LARGE_PRICE = 2.99;

    private Size size;
    private Flavor flavor;

    public Beverage(Size size, Flavor flavor, int quantity) {
       this.size = size;
       this.flavor = flavor;
       this.quantity = quantity;
    }

    @Override
    public double price() {
        return quantity * switch(size) {
            case SMALL -> SMALL_PRICE;
            case MEDIUM -> MEDIUM_PRICE;
            case LARGE  -> LARGE_PRICE;
        };
    }

    @Override
    public String toString() {
        return flavor + ", " + size + " " + formatter.format(price()) + "[" + quantity + "]";
    }

    public static void main(String[] args) {
        Beverage beverage = new Beverage(Size.LARGE, Flavor.MANGO, 2);
        System.out.println(beverage);
    }
}
