package com.Homework_11_10_18;

import java.math.BigDecimal;

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
    public static class PlaneBuilder{
        private int speed;
        private int yearOfManufacture;
        private BigDecimal price;
        private int numberOfPassengers;
        private int height;

        public PlaneBuilder(int speed, int yearOfManufacture, BigDecimal price) {
            this.speed = speed;
            this.yearOfManufacture = yearOfManufacture;
            this.price = price;
        }

        public PlaneBuilder numberOfPassengers(int passengers){
            this.numberOfPassengers = passengers;
            return this;
        }

        public PlaneBuilder height(int height){
            this.height = height;
            return this;
        }

        public Plane build(){
            return new Plane(this);
        }
    }

    private Plane(PlaneBuilder builder){
        this.numberOfPassengers = builder.numberOfPassengers;
        this.height = builder.height;
        setPrice(builder.price);
        setSpeed(builder.speed);
        setYearOfManufactured(builder.yearOfManufacture);
    }


    @Override
    public String toString() {
        return "Plane{" + super.toString()+
                ", height=" + height +
                ", numberOfpassengers=" + numberOfPassengers +
                '}';
    }
}
