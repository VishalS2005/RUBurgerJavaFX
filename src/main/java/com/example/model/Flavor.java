package com.example.model;

public enum Flavor {
    MANGO("Mango")
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
