package com.Homework_04_10_18;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Test
    public void maxEven() {
        assertEquals(8,Fibonacci.maxEven(7));
    }

    @Test
    public void maxOdd_size7_13() {
        assertEquals(13,Fibonacci.maxOdd(7));
        assertEquals(13,Fibonacci.maxOdd(7));
    }

    @Test
    public void percentageOfEven_size7_expectedPercent() {
        final double DELTA=0.1;
        final double EXPECTED = 28.57;
        assertEquals(EXPECTED,Fibonacci.percentageOfEven(7),DELTA);
    }
}