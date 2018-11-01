package com.Homework_11_10_18;

import com.Homework_11_10_18.Exceptions.IllegalArgumentsOfVehicleException;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Plane extends Vehicle implements FlyAble, Serializable {
    private int height;
    private int numberOfPassengers;

    public int getHeight() {

        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Plane plane = (Plane) o;
        return height == plane.height &&
                numberOfPassengers == plane.numberOfPassengers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), height, numberOfPassengers);
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
            final int NUMBER_OF_PASSENGERS_MAX= 10000;
            final int NUMBER_OF_PASSENGERS_MIN= 5;
            if(passengers<=NUMBER_OF_PASSENGERS_MIN || passengers>=NUMBER_OF_PASSENGERS_MAX) {
                throw new IllegalArgumentsOfVehicleException("passengers");
            }
            this.numberOfPassengers = passengers;
            return this;
        }

        public PlaneBuilder height(int height){
            final int HEIGHT_MAX= 100000;
            final int HEIGHT_MIN= 500;
            if(height<HEIGHT_MIN || height>HEIGHT_MAX) {
                throw new IllegalArgumentsOfVehicleException("height");
            }
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
