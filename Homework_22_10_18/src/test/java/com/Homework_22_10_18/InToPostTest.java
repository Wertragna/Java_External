package com.Homework_22_10_18;

import org.junit.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class InToPostTest {
    private InToPost transformator;
    @Before
    public void setUp() {
        transformator = new InToPost("10+5*7");
    }

    @Test
    public void transformCorrectInput(){
        Object[] actual = transformator.doTrans().toArray();
        Object[] expected = new String[]{
                "10", "5", "7", "*", "+"
        };
        assertArrayEquals(expected, actual);
    }



    @Test
    public void transformCorrectInputWithMathFunction(){
        transformator = new InToPost("sin( 1 / 2 *5)");
        Object[] actual = transformator.doTrans().toArray();
        Object[] expected = new String[]{
                "1", "2", "/", "5", "*", "sin"

        };
        assertArrayEquals(expected, actual);

    }
    @Test
    public void transformCorrectInputWithPow(){
        transformator = new InToPost("2^2^3");
        Object[] actual = transformator.doTrans().toArray();
        Object[] expected = new String[]{
                "2", "2", "3", "^", "^"
        };
        assertArrayEquals(expected, actual);

    }
    @Test
    public void transformCorrectInputWithPowWithParen(){
        transformator = new InToPost("(2^2)^3");
        Object[] actual = transformator.doTrans().toArray();
        Object[] expected = new String[]{
                "2", "2", "^", "3", "^"
        };
        assertArrayEquals(expected, actual);

    }


}
