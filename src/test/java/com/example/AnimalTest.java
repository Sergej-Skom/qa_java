package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class AnimalTest {
    private final String animalKind;
    private final List<String> food;

    public AnimalTest(String animalKind, List<String> food) {
        this.animalKind = animalKind;
        this.food = food;
    }

    @Parameterized.Parameters(name = "Тип животного: {0}, Что ест: {1}")
    public static Object[][] getCredentials() {
        return new Object[][] {
                { "Травоядное", List.of("Трава", "Различные растения")},
                { "Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                animal.getFamily());
    }

    @Test
    public void checkExceptionInGetFood() {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () -> animal.getFood("Обезьяна"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }
    @Test
    public void testGetFood() throws Exception {
        Animal animal = new Animal();
        assertEquals(food, animal.getFood(animalKind));
    }
}