package com.Homework_11_10_18;

public class Ship extends Vehicle implements SwimAble{
    private int numberOfPassengers;
    private int port;

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Ship{" + super.toString() +
                ", numberOfPassengers=" + numberOfPassengers +
                ", port=" + port +
                "} ";
    }
}
