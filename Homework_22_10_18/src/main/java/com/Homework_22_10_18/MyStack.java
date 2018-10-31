package com.Homework_22_10_18;

import java.util.*;

public class MyStack implements Iterable<String> {
    private   String[] stackArray;
    private final int DEFAULT_CAPACITY =16;
    private int top;

    public MyStack() {
        stackArray = new String[DEFAULT_CAPACITY];
        top= -1;
    }

    public MyStack(int initialCapacity) {
        top=-1;
        if (initialCapacity > 0) {
            stackArray = new String[initialCapacity];
        } else if (initialCapacity == 0) {
            stackArray = new String[]{};
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
        }
    }

    public Iterator<String> iterator() {
        Iterator <String> iterator = new Iterator<String>() {
            private int  currentIndex = 0;

            @Override
            public boolean hasNext() {
                return !isEmpty()&&currentIndex <= top;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public String next() {
                return stackArray[currentIndex++];
            }
        };
        return iterator;
    }


    public int size() {
        return top+1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void push(String Element) {
        grow(top+1);
        stackArray[++top] = Element;
    }

    public String peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return stackArray[top];
    }

    public String pop() {
        if (isEmpty())
            throw new NoSuchElementException();
        String pop= stackArray[top--];
        stackArray[top+1]=null;
        return pop;
    }

    private void grow(int minCapacity) {
        int oldCapacity = stackArray.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        stackArray = Arrays.copyOf(stackArray, newCapacity);
    }
}
