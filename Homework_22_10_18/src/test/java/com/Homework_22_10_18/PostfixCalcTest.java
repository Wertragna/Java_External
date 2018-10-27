package com.Homework_22_10_18;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PostfixCalcTest {
    PostfixCalc calc;

    public static final double DELTA = 0.1;

    @Before
    public void setUp() {
        calc = new PostfixCalc(new ArrayList<String>());
    }


    @Test
    public void isNumber_correctDigit_returnsTrue(){
        assertTrue(calc.isNumber("-112"));
        assertTrue(calc.isNumber("0"));
        assertTrue(calc.isNumber("115"));
        assertTrue(calc.isNumber("112.5"));
    }



    @Test
    public void isNumber_incorrectDigit_returnsFalse() {
        assertFalse(calc.isNumber("15z"));
        assertFalse(calc.isNumber(""));
    }



    @Test
    public void parse_correctInput_correctResult() {
        ArrayList expected = new ArrayList();
        fillTokenList(expected);
        calc = new PostfixCalc(expected);
        assertEquals(10, calc.parse(), DELTA);
    }



    private void fillTokenList(ArrayList<String> tokens) {
        tokens.add("12");
        tokens.add("2");
        tokens.add("3");
        tokens.add("4");
        tokens.add("-");
        tokens.add("*");
        tokens.add("+");
    }


    @Test
    public void parse_correctInputWithMathFunction_correctResult() {
        ArrayList expected = new ArrayList();
        fillTokenListWithMathFunction(expected);
        calc = new PostfixCalc(expected);
        double actual = calc.parse();
        assertEquals(14.07, actual, DELTA);
    }

    private void fillTokenListWithMathFunction(ArrayList<String> tokens) {
        tokens.add("5");
        tokens.add("3");
        tokens.add("*");
        tokens.add("2");
        tokens.add("7");
        tokens.add("3");
        tokens.add("/");
        tokens.add("+");
        tokens.add("sin");
        tokens.add("+");

    }
}
