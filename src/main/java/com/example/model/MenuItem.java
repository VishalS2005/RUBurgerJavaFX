package com.example.model;

public abstract class MenuItem {
    protected int quantity;
    public abstract double price();

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}