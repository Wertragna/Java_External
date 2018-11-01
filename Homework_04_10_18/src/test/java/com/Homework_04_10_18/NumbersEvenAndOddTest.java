package com.Homework_04_10_18;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumbersEvenAndOddTest {
    NumbersEvenAndOdd evenAndOdd;
    Interval interval;

    @Before
    public void setUp() {
        final int START = 0;
        final int END = 10;
        interval = new Interval(START, END);

    }

    @Test
    public void sumEvenNumbers_start0end10_30() {
        final int EXPECTED_SUM=30;
        assertEquals(EXPECTED_SUM,NumbersEvenAndOdd.sumEvenNumbers(interval));
    }

    @Test
    public void sumOddNumbers_start0end10_25() {
        final int EXPECTED_SUM=25;
        assertEquals(EXPECTED_SUM,NumbersEvenAndOdd.sumOddNumbers(interval));
    }

    @After
    public void tearDown() {
        interval = null;
    }
}