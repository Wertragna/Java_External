package com.Homework_11_10_18;

import java.math.BigDecimal;

public class AmphibiousCar extends Vehicle implements MoveAble, SwimAble{
    public AmphibiousCar(int speed, int yearOfManufacture, BigDecimal price) {
        setPrice(price);
        setYearOfManufactured(yearOfManufacture);
        setSpeed(speed);
    }

    @Override
    public String toString() {
        return "AmphibiousCar{" + super.toString()+ "}";
    }
}
