package com.Homework_22_10_18;

import org.junit.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyStackTest {
    private MyStack s;

    @Before
    public void init() {
        s = new MyStack();
    }

    @After
    public void clean() {
        s= null;
    }

    @Test
    public void testNewStackIsEmpty() {
        final int SIZE_OF_EMPTY_STACK=0;

        boolean isEmptyActual = s.isEmpty();
        int sizeActual = s.size();

        assertTrue(isEmptyActual);
        assertEquals(sizeActual, SIZE_OF_EMPTY_STACK);
    }

    @Test
    public void testPushesToEmptyStack() {
        final int  NUMBER_OF_PUSHES_EXPECTED = 6;
        for (int i = 0; i < NUMBER_OF_PUSHES_EXPECTED; i++) {
            s.push("zzz");
        }

        int numberOfPushesActual = s.size();
        boolean isEmpty= s.isEmpty();

        assertFalse(isEmpty);
        assertEquals(NUMBER_OF_PUSHES_EXPECTED, numberOfPushesActual);
    }

    @Test
    public void testPushThenPop() {
        String MESSAGE = "hello";

        s.push(MESSAGE);

        assertEquals(s.pop(), MESSAGE);
    }

    @Test
    public void testPushThenPeek() {
        String MESSAGE = "hello";

        s.push(MESSAGE);

        int sizeAfterPushAndBeforePeek = s.size();

        assertEquals(s.peek(), MESSAGE);

        int sizeAfterPeek = s.size();
        assertEquals(sizeAfterPeek, sizeAfterPushAndBeforePeek);
    }

    @Test
    public void testPoppingDownToEmpty() {
        final int SIZE_OF_EMPTY_STACK=0;
        int NUMBER_OF_PUSHES=5;

        for (int i = 0; i < NUMBER_OF_PUSHES; i++) {
            s.push("something");
        }
        for (int i = 0; i < NUMBER_OF_PUSHES; i++) {
            s.pop();
        }
        boolean isEmpty = s.isEmpty();
        int sizeActual = s.size();

        assertTrue(isEmpty);
        assertEquals(SIZE_OF_EMPTY_STACK,sizeActual);
    }

    @Test(expected=NoSuchElementException.class)
    public void testPopOnEmptyStack() {
        boolean isEmpty = s.isEmpty();
        assertTrue(isEmpty);
        s.pop();
    }

    @Test(expected= NoSuchElementException.class)
    public void testPeekIntoEmptyStack() {
        boolean isEmpty = s.isEmpty();
        assertTrue(isEmpty);
        s.peek();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testInitWithIllegalCapacity() {
        final int WRONG_CAPACITY=-5;
        s= new MyStack(WRONG_CAPACITY);
    }

    @Test
    public void testInitWithRightCapacity() {
        final int RIGHT_CAPACITY=5;
        final int ZERO_CAPASITY = 0;
        s= new MyStack(RIGHT_CAPACITY);
        s= new MyStack(ZERO_CAPASITY);
    }


    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorRemove() {
        s.iterator().remove();
    }
    @Test
    public void testIterator() {
        String MESSAGE = "hello";
        s.push(MESSAGE);
        Iterator<String> iterator = s.iterator();
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        assertEquals(MESSAGE,iterator.next());
        assertFalse(iterator.hasNext());
    }


}
