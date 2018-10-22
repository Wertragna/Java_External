package com.Homework_11_10_18;

import java.math.BigDecimal;

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
    public static class ShipBuilder{
        private int speed;
        private int yearOfManufacture;
        private BigDecimal price;
        private int numberOfPassengers;
        private int port;

        public ShipBuilder(int speed, int yearOfManufacture, BigDecimal price) {
            this.speed = speed;
            this.yearOfManufacture = yearOfManufacture;
            this.price = price;
        }

        public ShipBuilder numberOfPassengers(int passengers){
            final int NUMBER_OF_PASSENGERS_MAX= 10000;
            final int NUMBER_OF_PASSENGERS_MIN= 5;
            if(passengers<=NUMBER_OF_PASSENGERS_MIN || passengers>=NUMBER_OF_PASSENGERS_MAX) {
                throw new IllegalArgumentsOfVehicleException("passengers");
            }
            this.numberOfPassengers = passengers;
            return this;
        }

        public ShipBuilder port(int port){
            final int PORT_MAX= 10000;
            final int PORT_MIN= 500;
            if(port<=PORT_MIN || port>=PORT_MAX) {
                throw new IllegalArgumentsOfVehicleException("port");
            }
            this.port = port;
            return this;
        }

        public Ship build(){
            return new Ship(this);
        }
    }

    private Ship(ShipBuilder builder){
        this.numberOfPassengers = builder.numberOfPassengers;
        this.port = builder.port;
        setPrice(builder.price);
        setSpeed(builder.speed);
        setYearOfManufactured(builder.yearOfManufacture);
    }

    @Override
    public String toString() {
        return "Ship{" + super.toString() +
                ", numberOfPassengers=" + numberOfPassengers +
                ", port=" + port +
                "} ";
    }

}
