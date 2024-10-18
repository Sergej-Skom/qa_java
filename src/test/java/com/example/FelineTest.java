package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy Feline feline;

    @Parameterized.Parameter(0)
    public int kittensCount;

    @Parameterized.Parameter(1)
    public int expectedKittensCount;

    @Parameterized.Parameters public static Object[] getDataKittensCount() {
        return new Object[][]{
                {1, 1},
                {3, 3},
                {10, 10},
        };
    }

    @Test
    public void getKittensCountReturns() {
        int actualKittensCount = feline.getKittens(kittensCount);
        assertEquals(expectedKittensCount, actualKittensCount);
    }

    @Test
    public void getEatMeatReturnsForFeline() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedEatMeat = List.of("Животные", "Птицы", "Рыба");
        List<String> actualEatMeat = feline.eatMeat();
        assertEquals(expectedEatMeat, actualEatMeat);
    }

    @Test
    public void getFamilyReturnsForFeline() {
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        String expectedFamily = "Кошачьи";
        assertEquals(expectedFamily, actualFamily);
    }

    @Test public void getKittensReturnsForFeline() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualKittensCount = feline.getKittens();
        int expectedKittensCount = 1;
        assertEquals(expectedKittensCount, actualKittensCount);
    }
}