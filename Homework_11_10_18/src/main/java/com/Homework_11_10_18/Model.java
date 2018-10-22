package com.Homework_11_10_18;

import java.math.BigDecimal;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Model {
    public List<Vehicle> vehicleList = new ArrayList<>();
    public ListOfVehicleByFlyMoveSwim listOfVehicleByFlyMoveSwim;

    public Model() {
        listOfVehicleByFlyMoveSwim = new ListOfVehicleByFlyMoveSwim();
    }

    public void addVehicle(Vehicle vehicle){
        vehicleList.add(vehicle);
    }

    public void addCar(int speed, int yearOfManufacture, BigDecimal price){
        Vehicle car = new Car(speed,yearOfManufacture,price);
        vehicleList.add(car);
    }

    public void addPlane(int speed, int yearOfManufacture, BigDecimal price, int numberOfPassengers, int height ){
        Vehicle plane =  new Plane.PlaneBuilder(speed,yearOfManufacture, price)
                .numberOfPassengers(numberOfPassengers)
                .height(height)
                .build();
    }

    public  void  addShip(int speed, int yearOfManufacture, BigDecimal price, int numberOfPassengers, int port ){
    Vehicle ship =new  Ship.ShipBuilder(speed, yearOfManufacture, price)
            .numberOfPassengers(numberOfPassengers)
                .port(port)
                .build();
    }

    public void addBetMobile(int speed, int yearOfManufacture, BigDecimal price){
        Vehicle betMobile = new BetMobile(speed,yearOfManufacture,price);
        vehicleList.add(betMobile);
    }

    public void addAmphibiousCar(int speed, int yearOfManufacture, BigDecimal price){
        Vehicle amphibiousCar = new AmphibiousCar(speed,yearOfManufacture,price);
        vehicleList.add(amphibiousCar);
    }

    public List<Vehicle> getPlanesWithHeightMoreThanXYearOfManufactureAfterY(int xHeignt, int yYears) {
        return VehicleFinder.getPlanesWithHeightMoreThanXYearOfManufactureAfterY( vehicleList,xHeignt,yYears);
    }
    public  List <Vehicle> getNotPlaneWithSpeedBetweenXAndY( int xSpeed, int ySpeed) {
        return VehicleFinder.getNotPlaneWithSpeedBetweenXAndY(vehicleList,xSpeed,ySpeed);
    }
    public  List<Vehicle> getWithMaxSpeed(){
        return VehicleFinder.getWithMaxSpeed(vehicleList);
    }
    public  List<Vehicle> getWithMinPriceAndMaxSpeedYoungerThanXYears(int ageLimit){
        return VehicleFinder.getWithMinPriceAndMaxSpeedYoungerThanXYears(vehicleList,ageLimit);
    }
}
   /* public List <Vehicle> getVehicleWithSpeedMoreThanX(int xSpeed) {
        return VehicleFinder.(vehicleList,xSpeed);
    }*/
