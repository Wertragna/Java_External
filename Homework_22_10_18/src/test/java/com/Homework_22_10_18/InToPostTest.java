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
        transformator = new InToPost("12+5*7");
    }

    @Test
    public void transformCorrectInput(){
        Object[] actual = transformator.doTrans().toArray();
        Object[] expected = new String[]{
                "12", "5", "7", "*", "+"
        };
        assertArrayEquals(expected, actual);
    }



    @Test
    public void transformCorrectInputWithMathFunction(){
        transformator = new InToPost("sin(1/2*3)");
        Object[] actual = transformator.doTrans().toArray();
        Object[] expected = new String[]{
                "1", "2", "/", "3", "*", "sin"

        };
        assertArrayEquals(expected, actual);

    }


}
