package Server.Calculator;

import Server.Calculator.PostfixCalc;
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
        assertTrue(calc.isNumber("-5"));
        assertTrue(calc.isNumber("0"));
        assertTrue(calc.isNumber("5"));
        assertTrue(calc.isNumber("112.55"));
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
        assertEquals(-2, calc.parse(), DELTA);
    }



    private void fillTokenList(ArrayList<String> tokens) {
        tokens.add("12");
        tokens.add("2");
        tokens.add("3");
        tokens.add("4");
        tokens.add("+");
        tokens.add("*");
        tokens.add("-");
    }


    @Test
    public void parseInputWithSin() {
        ArrayList expected = new ArrayList();
        fillTokenListWithSin(expected);
        calc = new PostfixCalc(expected);
        double actual = calc.parse();
        assertEquals(14.07, actual, DELTA);
    }

    private void fillTokenListWithSin(ArrayList<String> tokens) {
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

    @Test
    public void parseInputWithPow() {

        ArrayList expected = new ArrayList();
        fillTokenListWithPow(expected);
        calc = new PostfixCalc(expected);
        double actual = calc.parse();
        assertEquals(64, actual, DELTA);
    }

    private void fillTokenListWithPow(ArrayList<String> tokens) {
        tokens.add("2");
        tokens.add("2");
        tokens.add("^");
        tokens.add("3");
        tokens.add("^");
    }
    @Test(expected = ArithmeticException.class)
    public void parseInputWithDivideZero() {

        ArrayList expected = new ArrayList();
        fillTokenListWithDivideZero(expected);
        calc = new PostfixCalc(expected);
        double result = calc.parse();

    }

    private void fillTokenListWithDivideZero(ArrayList<String> tokens) {
        tokens.add("2");
        tokens.add("0");
        tokens.add("/");

    }
}
