package com.Homework_04_10_18;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntervalTest {
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_WrongStartAndEndInterval_exception() {
        final int START=5;
        final int END =-1;
        Interval interval = new Interval(START,END);
    }
}