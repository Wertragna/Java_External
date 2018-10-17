package com.Homework_11_10_18;

import java.math.BigDecimal;

public abstract class Vehicle {

    private BigDecimal price;
    private int speed;
    private int yearOfManufacture;

    

    public BigDecimal getPrice() {
        return price;
    }

    public int getSpeed() {
        return speed;
    }

    public int getYearOfManufactured() {
        return yearOfManufacture;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setYearOfManufactured(int yearOfManufactured) {
        this.yearOfManufacture = yearOfManufactured;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "price=" + price +
                ", speed=" + speed +
                ", yearOfManufacture=" + yearOfManufacture +
                '}';
    }

    @Override
    protected Vehicle clone() {
        try{
            return (Vehicle)super.clone();
        }
        catch (CloneNotSupportedException exc) {
            throw new AssertionError();
        }
    }
}
