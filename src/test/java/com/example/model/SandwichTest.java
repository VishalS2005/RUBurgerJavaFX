package com.example.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class SandwichTest {

    private Sandwich roastBeefLettuceTomatoesOnions;

    private Sandwich salmonAvocadoCheese;

    private Sandwich chickenOnionsAvocado;

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
        roastBeefLettuceTomatoesOnions = new Sandwich(Bread.BAGEL, Protein.ROAST_BEEF, lettuceTomatoesOnions);
        salmonAvocadoCheese = new Sandwich(Bread.SOURDOUGH, Protein.SALMON, avocadoCheese);
        chickenOnionsAvocado =  new Sandwich(Bread.BRIOCHE, Protein.CHICKEN, onionsAvocado);
    }


    @Test
    public void roastBeefLettuceTomatoesOnionsPrice() {
        assertEquals(11.89, roastBeefLettuceTomatoesOnions.price(), 0.01);
    }

    @Test
    public void salmonAvocadoCheesePrice() {
        assertEquals(11.49, salmonAvocadoCheese.price(), 0.01);
    }

    @Test
    public void chickenOnionsAvocadoPrice() {
        assertEquals(9.79,  chickenOnionsAvocado.price(), 0.01);
    }
}
