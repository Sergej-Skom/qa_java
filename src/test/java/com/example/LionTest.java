package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int countOfKittens = lion.getKittens();
        Assert.assertEquals(1, countOfKittens);
    }

    @Test
    public void testDoesHaveManeIsException() {

        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Самка", feline);
        });
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> listOfFoodExp = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(listOfFoodExp);
        List<String> listOfFoodAct = lion.getFood();
        Assert.assertEquals(listOfFoodExp, listOfFoodAct);
    }
}