package com.Task041018;


public class Number {
    private int value;
    private boolean isEven;

    public Number(int number) {
        value = number;
        if(value % 2 == 0) {
            isEven = true;
        }
        else {
            isEven = false;
        }
    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {
        return isEven;
    }
}
