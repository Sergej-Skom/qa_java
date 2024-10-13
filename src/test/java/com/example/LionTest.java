package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private final boolean havMane;

    Feline feline = new Feline();

    public LionTest(String sex, boolean havMane) {
        this.sex = sex;
        this.havMane = havMane;
    }

    @Parameterized.Parameters(name = "Пол: {0}, Наличие гривы: {1}")
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void testHasMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(havMane, lion.hasMane());
    }

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertEquals(feline.getKittens(), lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertEquals(feline.getFood("Хищник"), lion.getFood());
    }
    @Test
    public void testLionConstructor_InvalidSex_ThrowsException() {
        try {
            new Lion("Недопустимый пол", feline);
            fail("Ожидалось исключение для недопустимого пола");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
}


