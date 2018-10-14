package com.Homework_11_10_18;

public class Plane extends Vehicle implements FlyAble {
    private int height;
    private int numberOfpassengers;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getNumberOfpassengers() {
        return numberOfpassengers;
    }

    public void setNumberOfpassengers(int numberOfpassengers) {
        this.numberOfpassengers = numberOfpassengers;
    }
}
