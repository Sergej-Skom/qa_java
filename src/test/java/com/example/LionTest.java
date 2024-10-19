package com.example;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.List;

public class LionTest {
    private Lion lion;
    private Feline mockFeline;

    @Before
    public void setUp() throws Exception {
        mockFeline = Mockito.mock(Feline.class);
        lion = new Lion("Самец");

        Field field = Lion.class.getDeclaredField("feline");
        field.setAccessible(true);
        field.set(lion, mockFeline);
    }

    @Test
    public void testDoesHaveMane() {
        assertTrue(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception {
        new Lion("Неизвестный пол");
    }

    @Test
    public void testGetKittens() {
        Mockito.when(mockFeline.getKittens()).thenReturn(3);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы"));
        List<String> food = lion.getFood();
        assertNotNull(food);
        assertEquals(2, food.size());
        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
    }
}