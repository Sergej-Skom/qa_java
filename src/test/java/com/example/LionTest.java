package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionTest {

    @Mock Feline feline;

    @Parameterized.Parameter(0)
    public String sex;

    @Parameterized.Parameter(1)
    public boolean expectedHasMane;

    @Parameterized.Parameters
    public static Object[][] getDataHasMane() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before public void init() {
        MockitoAnnotations.openMocks(this); // Инициализация моков
    }

    @Test public void getHaveManeReturns() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals(expectedHasMane, actualHasMane);
    }

    @Test
    public void getKittensReturnsForLion() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedKittens = 1;
        int actualKittens = lion.getKittens();
        assertEquals(expectedKittens, actualKittens);
    }

    @Test public void getFoodReturnsForLion() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedEatMeat = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedEatMeat);
        List<String> actualEatMeat = lion.getFood();
        assertEquals(expectedEatMeat, actualEatMeat);
    }

    @Test
    public void doesHaveManeException() {
        String exceptionLion = "Оно";
        Exception exception = assertThrows(Exception.class, () -> new Lion(exceptionLion, feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}