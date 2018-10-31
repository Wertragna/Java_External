package com.Homework_11_10_18;

import java.io.Serializable;
import java.math.BigDecimal;

public class BetMobile extends Vehicle implements FlyAble, MoveAble, Serializable {
    public BetMobile(int speed, int yearOfManufacture, BigDecimal price) {
        setPrice(price);
        setYearOfManufactured(yearOfManufacture);
        setSpeed(speed);
    }

    @Override
    public String toString() {
        return "BetMobile{" + super.toString()+" }";
    }
}
