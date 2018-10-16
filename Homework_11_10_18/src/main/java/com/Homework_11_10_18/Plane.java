package com.Homework_11_10_18;

public class Plane extends Vehicle implements FlyAble {
    private int height;
    private int numberOfPassengers;

    public int getHeight() {

        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfpassengers(int numberOfpassengers) {
        this.numberOfPassengers = numberOfpassengers;
    }

    @Override
    public String toString() {
        return "Plane{" + super.toString()+
                ", height=" + height +
                ", numberOfpassengers=" + numberOfPassengers +
                '}';
    }
}
