package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundReturnsForCat() {
        Cat cat = new Cat(feline);
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        Assert.assertEquals(expectedSound, actualSound);
    }

        @Test
    public void getFoodReturnsForCat() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedEatMeat = List.of("Животные", "Птицы", "Рыба");
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
        Mockito.when(feline.eatMeat()).thenReturn(expectedEatMeat);
        Assert.assertEquals(expectedEatMeat, feline.eatMeat());
        Assert.assertEquals(expectedEatMeat, cat.getFood());
    }
}