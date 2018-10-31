package com.Homework_11_10_18;

import java.io.Serializable;
import java.math.BigDecimal;

public class Car extends Vehicle implements MoveAble, Serializable {
    public Car(int speed, int yearOfManufacture, BigDecimal price) {
        setPrice(price);
        setYearOfManufactured(yearOfManufacture);
        setSpeed(speed);
    }
}
