package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class AnimalTest {

    private final String sex;
    private final boolean expectedHasMane;

    public AnimalTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Feline mockFeline = mock(Feline.class);
        Lion lion = new Lion(sex);
        setFeline(lion, mockFeline);

        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline mockFeline = mock(Feline.class);
        List<String> expectedFood = List.of("Животные", "Птицы");
        when(mockFeline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion(sex);
        setFeline(lion, mockFeline);

        List<String> food = lion.getFood();

        assertEquals(expectedFood, food);
    }

    private void setFeline(Lion lion, Feline feline) {
        try {
            java.lang.reflect.Field field = Lion.class.getDeclaredField("feline");
            field.setAccessible(true);
            field.set(lion, feline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}