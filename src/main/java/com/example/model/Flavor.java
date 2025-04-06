package com.example.model;

public enum Flavor {
    COLA("Cola"),
    LIME("Lime"),
    ORANGE("Orange"),
    CHERRY("Cherry"),
    TEA("Tea"),
    MANGO("Mango"),
    STRAWBERRY("Strawberry"),
    RASPBERRY("Raspberry"),
    GRAPE("Grape"),
    LEMONADE("Lemonade"),
    SMOOTHIES("Smoothies"),
    MILK("Milk"),
    JUICE("Juice"),
    WATER("Water"),
    COFFEE("Coffee"),
    ;

    public final String name;
    Flavor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
