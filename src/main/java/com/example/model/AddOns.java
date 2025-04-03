package com.example.model;

public enum AddOns {
    LETTUCE("Lettuce", 0.3),
    TOMATOES("Tomatoes", 0.3),
    ONIONS("Onions", 0.3),
    AVOCADO("Avocado", 0.5),
    CHEESE("Cheese", 1.0);

    private final String name;
    private final double price;

    AddOns(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
