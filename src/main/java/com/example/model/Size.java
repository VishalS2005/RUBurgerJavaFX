package com.example.model;

public enum Size {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large"),
    ;

    private final String name;

    Size(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
