package com.example.model;

public enum Protein {
    ROAST_BEEF("Roast Beef"),
    SALMON("Salmon"),
    CHICKEN("Chicken"),
    BEEF_PATTY("Beef Patty"),
    ;
    private final String name;

    Protein(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
