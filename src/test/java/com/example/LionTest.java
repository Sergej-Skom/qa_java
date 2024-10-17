package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private final boolean haveMane;
    private final Feline feline;

    public LionTest(String sex, boolean haveMane) {
        this.sex = sex;
        this.haveMane = haveMane;
        this.feline = new Feline();
    }

    @Parameterized.Parameters(name = "Пол: {0}, Наличие гривы: {1}")
    public static Object[][] getLionTestCases() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void testHasMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(haveMane, lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertEquals(feline.getKittens(), lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertEquals(feline.eatMeat(), lion.getFood());
    }

    @Test
    public void testInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Некорректный пол", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
