package com.example.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * A test class for verifying the functionality and pricing of the Burger class.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public class BurgerTest {

    /**
     * A burger with single patty, lettuce and tomatoes add-ons
     */
    private Burger singleLettuceTomatoes;

    /**
     * A burger with double patty, onions and cheese add-ons
     */
    private Burger doubleOnionsCheese;

    /**
     * Sets up test fixtures before each test method is executed.
     * Initializes two Burger objects:
     * 1. Single patty with lettuce and tomatoes on pretzel bread
     * 2. Double patty with onions and cheese on wheat bread
     */
    @Before
    public void setUp() {
        ArrayList<AddOns> lettuceTomatoes = new ArrayList<>();
        ArrayList<AddOns> onionsCheese = new ArrayList<>();
        lettuceTomatoes.add(AddOns.LETTUCE);
        lettuceTomatoes.add(AddOns.TOMATOES);
        onionsCheese.add(AddOns.ONIONS);
        onionsCheese.add(AddOns.CHEESE);
        singleLettuceTomatoes = new Burger(Bread.PRETZEL, false, lettuceTomatoes, 1);
        doubleOnionsCheese = new Burger(Bread.WHEAT_BREAD, true, onionsCheese, 2);
    }

    /**
     * Tests the price calculation for a single patty burger
     * with lettuce and tomatoes add-ons.
     * Verifies that the calculated price matches the expected value of 7.59.
     */
    @Test
    public void singleLettuceTomatoesPrice() {
        assertEquals(7.59, singleLettuceTomatoes.price(), 0.01);
    }

    /**
     * Tests the price calculation for a double patty burger
     * with onions and cheese add-ons.
     * Verifies that the calculated price matches the expected value of 21.58.
     */
    @Test
    public void doubleOnionsCheesePrice() {
        assertEquals(21.58, doubleOnionsCheese.price(), 0.01);
    }
}
