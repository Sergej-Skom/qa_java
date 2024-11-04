package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String checkingValue;
    private final boolean expectedValue;

    public LionParameterizedTest(String checkingValue,boolean expectedValue){
        this.checkingValue = checkingValue;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Feline kot = new Feline();
        Lion lion = new Lion(checkingValue,kot);
        boolean actual = lion.doesHaveMane();
        assertEquals(expectedValue,actual);
    }
}