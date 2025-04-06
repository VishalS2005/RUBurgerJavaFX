package com.example.model;

public enum Bread {
    BRIOCHE("Brioche"),
    WHEAT_BREAD("Wheat"),
    PRETZEL("Pretzel"),
    BAGEL("Bagel"),
    SOURDOUGH("Sourdough"),
    ;
    private final String name;

    Bread(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

