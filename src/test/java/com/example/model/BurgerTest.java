package com.example.model;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BurgerTest {

    private Burger singleLettuceTomatoes;
    private Burger doubleOnionsCheese;

    @Before
    public void seUp() {
        ArrayList<AddOns> lettuceTomatoes = new ArrayList<>();
        ArrayList<AddOns> onionsCheese = new ArrayList<>();
        lettuceTomatoes.add(AddOns.LETTUCE);
        lettuceTomatoes.add(AddOns.TOMATOES);
        onionsCheese.add(AddOns.ONIONS);
        onionsCheese.add(AddOns.CHEESE);
        singleLettuceTomatoes = new Burger(Bread.PRETZEL, false, lettuceTomatoes);
        doubleOnionsCheese = new Burger(Bread.WHEAT_BREAD, true, onionsCheese);
    }

    @Test
    public void singleLettuceTomatoesprice() {
       assertEquals(7.59,   singleLettuceTomatoes.price(), 0.01);
    }

    @Test
    public void doubleOnionsCheesePrice() {
        assertEquals(10.79,  doubleOnionsCheese.price(), 0.01);
    }
}
