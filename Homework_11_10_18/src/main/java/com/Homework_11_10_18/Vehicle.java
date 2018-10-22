package com.Homework_11_10_18;

import java.math.BigDecimal;
import java.util.Calendar;

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

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setPrice(BigDecimal price) {
        final long PRICE_MIN = 100;
        if (price.compareTo(BigDecimal.valueOf(PRICE_MIN))<=0)
            throw new IllegalArgumentsOfVehicleException("price");
        this.price = price;
    }

    public void setSpeed(int speed) {
        final int SPEED_MAX = 2000;
        final int SPEED_MIN = 20;
        if(speed<=SPEED_MIN || speed>=SPEED_MAX) {
            throw new IllegalArgumentsOfVehicleException("speed");
        }
        this.speed = speed;
    }

    public void setYearOfManufactured(int yearOfManufactured) {
        final int YEAR_MAX = Calendar.getInstance().get(Calendar.YEAR);
        final int YEAR_MIN = 1900;
        if(yearOfManufactured <= YEAR_MIN || yearOfManufactured>YEAR_MAX) {
            throw  new IllegalArgumentsOfVehicleException("year");
        }
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
        try {
            return (Vehicle)super.clone();
        }
        catch (CloneNotSupportedException exc) {
            throw new AssertionError();
        }
    }
}
