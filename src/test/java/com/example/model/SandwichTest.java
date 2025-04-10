package com.example.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * A test class for verifying the functionality and pricing of Sandwich.
 * Contains test cases for sandwiches with various protein choices, bread types, and add-on combinations.
 *
 * @author Vishal Saravanan, Yining Chen
 */
public class SandwichTest {

    /**
     * Sandwich instance with roast beef protein, lettuce, tomatoes, and onions add-ons,
     * served on a bagel with single portion.
     */
    private Sandwich roastBeefLettuceTomatoesOnions;

    /**
     * Sandwich instance with salmon protein, avocado and cheese add-ons,
     * served on sourdough bread with double portion.
     */
    private Sandwich salmonAvocadoCheese;

    /**
     * Sandwich instance with chicken protein, onions and avocado add-ons,
     * served on brioche bread with triple portion.
     */
    private Sandwich chickenOnionsAvocado;

    /**
     * Initializes test fixtures before each test execution.
     * Creates three Sandwiches:
     * 1. Roast beef with lettuce, tomatoes, onions on bagel (single portion)
     * 2. Salmon with avocado and cheese on sourdough (double portion)
     * 3. Chicken with onions and avocado on brioche (triple portion)
     */
    @Before
    public void setUp() {
        ArrayList<AddOns> lettuceTomatoesOnions = new ArrayList<>();
        ArrayList<AddOns> avocadoCheese = new ArrayList<>();
        ArrayList<AddOns> onionsAvocado = new ArrayList<>();

        lettuceTomatoesOnions.add(AddOns.LETTUCE);
        lettuceTomatoesOnions.add(AddOns.TOMATOES);
        lettuceTomatoesOnions.add(AddOns.ONIONS);

        avocadoCheese.add(AddOns.AVOCADO);
        avocadoCheese.add(AddOns.CHEESE);

        onionsAvocado.add(AddOns.ONIONS);
        onionsAvocado.add(AddOns.AVOCADO);

        roastBeefLettuceTomatoesOnions = new Sandwich(Bread.BAGEL, Protein.ROAST_BEEF, lettuceTomatoesOnions, 1);
        salmonAvocadoCheese = new Sandwich(Bread.SOURDOUGH, Protein.SALMON, avocadoCheese, 2);
        chickenOnionsAvocado = new Sandwich(Bread.BRIOCHE, Protein.CHICKEN, onionsAvocado, 3);
    }

    /**
     * Tests price calculation for a roast beef sandwich with lettuce, tomatoes, and onions.
     * Verifies the base price with standard add-ons matches the expected value of 11.89.
     */
    @Test
    public void roastBeefLettuceTomatoesOnionsPrice() {
        assertEquals(11.89, roastBeefLettuceTomatoesOnions.price(), 0.01);
    }

    /**
     * Tests price calculation for a salmon sandwich with premium add-ons (avocado and cheese).
     * Verifies the price with double portion matches the expected value of 22.98.
     */
    @Test
    public void salmonAvocadoCheesePrice() {
        assertEquals(22.98, salmonAvocadoCheese.price(), 0.01);
    }

    /**
     * Tests price calculation for a chicken sandwich with onions and avocado in triple portion.
     * Verifies the price calculation for maximum portion size matches the expected value of 29.37.
     */
    @Test
    public void chickenOnionsAvocadoPrice() {
        assertEquals(29.37, chickenOnionsAvocado.price(), 0.01);
    }
}
