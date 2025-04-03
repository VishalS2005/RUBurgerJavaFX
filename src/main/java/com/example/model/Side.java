package com.example.model;

public enum Side {

    CHIPS("Chips", 1.99),
    FRIES("Fries", 2.49),
    ONION_RINGS("Onion Rings", 3.29),
    APPLE_SLICES("Apple Slices", 1.29),
    ;

    private final String name;
    private final double price;


    Side(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice(Size size) {
        return price + switch(size) {
            case SMALL -> 0;
            case MEDIUM -> 0.5;
            case LARGE -> 1;
        };
    }
}
