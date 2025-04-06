package com.example.model;

import java.text.NumberFormat;
import java.util.Locale;

public class Sides extends MenuItem{

    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
    private Side side;
    private Size size;

    public Sides(Side side, Size size, int quantity) {
        this.side = side;
        this.size = size;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return side + ", " + size + "[" + quantity + "]" + formatter.format(price());
    }

    @Override
    public double price() {
        return quantity * side.getPrice(size);
    }

    public static void main(String[] args) {
        Sides sides = new Sides(Side.ONION_RINGS, Size.SMALL, 1);
        System.out.println(sides);
    }
}
