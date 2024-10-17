package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Predator predator;

    @Test
    public void testGetSound() {
        var cat = new Cat(predator);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("one", "two");
        when(predator.eatMeat()).thenReturn(expectedFood);

        var cat = new Cat(predator);
        assertEquals(expectedFood, cat.getFood());
    }
}