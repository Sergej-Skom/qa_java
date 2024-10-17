package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        assertEquals("Животные, Птицы, Рыба", String.join(", ", feline.eatMeat()));
    }
    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens()); // Тестируем, что по умолчанию возвращается 1 котенок
    }

    @Test
    public void testGetKittensWithCount() {
        Feline feline = new Feline();
        assertEquals(3, feline.getKittens(3)); // Тестируем, что можно указать количество котят
    }
}
