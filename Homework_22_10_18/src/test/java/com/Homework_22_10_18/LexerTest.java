package com.Homework_22_10_18;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesPattern;
import static org.junit.Assert.*;


public class LexerTest {
    String exp;
    static Lexer lexer;


    @Before
    public void init(){
        exp="";
        lexer = new Lexer(exp);
    }

    @After
    public void clean(){
        lexer= null;
    }

    @Test
    public void testIntegerIsDigitString(){
        String START_LETTER ="555sin(5)";
        Lexer lexer = new Lexer(START_LETTER);

        assertThat(lexer.Integer(), matchesPattern("[0-9]+"));
    }

    @Test
    public void testLetter(){
        String START_LETTER ="sin(5)";
        Lexer lexer = new Lexer(START_LETTER);

        assertThat(lexer.Letter(), matchesPattern("[a-zA-Z]+"));
    }

    @Test
    public void testInteger(){
        String START_DIGITS ="123456789sdfksdfk-3345";
        String EXPECTED = "123456789";
        Lexer lexer = new Lexer(START_DIGITS);

        assertEquals(EXPECTED,lexer.Integer());
    }

    @Test
    public void testWhiteSpaces() {
        int SIX = 6;
        String START_SIX_WHITE_SPACES ="      ";
        lexer = new Lexer(START_SIX_WHITE_SPACES);

        assertEquals(6, lexer.SkipWhitespace());
    }

    @Test
    public void testDeque(){
        String RIGHT_EXP= "5+5-10*5+(6*7)^sin ";
        lexer = new Lexer(RIGHT_EXP);
        ArrayList<String> EXPECTED = new ArrayList<>();
        EXPECTED.add("5");
        EXPECTED.add("+");
        EXPECTED.add("5");
        EXPECTED.add("-");
        EXPECTED.add("10");
        EXPECTED.add("*");
        EXPECTED.add("5");
        EXPECTED.add("+");
        EXPECTED.add("(");
        EXPECTED.add("6");
        EXPECTED.add("*");
        EXPECTED.add("7");
        EXPECTED.add(")");
        EXPECTED.add("^");
        EXPECTED.add("sin");
        assertThat(lexer.getArrayOfToken(),equalTo(EXPECTED));
    }

    @Test(expected = LexerException.class)
    public void testExpectedLexerExceptionWhenLettersSubstringNotOper() {
        String SINS= "sins";
        lexer = new Lexer(SINS);
        lexer.getNextToken();
    }

    @Test(expected = LexerException.class)
    public void testGetNextTokenWithIllegalCharacter() {
        String SINS= "&";
        lexer = new Lexer(SINS);
        lexer.getNextToken();
    }
}



