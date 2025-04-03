package com.example.model;

public class Beverage extends MenuItem {
    private Size size;
    private Flavor flavor;

    @Override
    public double price() {
        return 0;
    }
}
