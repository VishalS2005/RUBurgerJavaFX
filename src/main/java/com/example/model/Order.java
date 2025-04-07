package com.example.model;

import java.util.ArrayList;

public class Order {
    private int number; //a unique integer to identify the order
    private ArrayList<MenuItem> items;
    private static int counter = 1;

    public Order(ArrayList<MenuItem> items) {
       this.number = counter++;
       this.items = items;
    }

    public int getNumber() {
        return number;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }


}
