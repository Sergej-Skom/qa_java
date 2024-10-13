package com.example;

import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;

public class FelineTest extends TestCase {

    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        assertEquals("Животные, Птицы, Рыба", String.join(", ",
                feline.eatMeat()));
    }

    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }
}
