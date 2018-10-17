package com.Homework_11_10_18;

import java.math.BigDecimal;

public class Car extends Vehicle{
    public Car(int speed, int yearOfManufacture, BigDecimal price) {
        setPrice(price);
        setYearOfManufactured(yearOfManufacture);
        setSpeed(speed);
    }
}
