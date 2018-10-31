package com.Homework_11_10_18;

import java.math.BigDecimal;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class VehicleModel {
    public ArrayList<Vehicle> vehicleList = new ArrayList<>();
    public ListOfVehicleByFlyMoveSwim listOfVehicleByFlyMoveSwim;

    public VehicleModel() {
        listOfVehicleByFlyMoveSwim = new ListOfVehicleByFlyMoveSwim();
    }

    public void addVehicle(Vehicle vehicle){
        vehicleList.add(vehicle);
    }

    public ArrayList<Vehicle> getPlanesWithHeightMoreThanXYearOfManufactureAfterY(int xHeignt, int yYears) {
        return VehicleFinder.getPlanesWithHeightMoreThanXYearOfManufactureAfterY( vehicleList,xHeignt,yYears);
    }
    public  ArrayList <Vehicle> getNotPlaneWithSpeedBetweenXAndY( int xSpeed, int ySpeed) {
        return VehicleFinder.getNotPlaneWithSpeedBetweenXAndY(vehicleList,xSpeed,ySpeed);
    }
    public  ArrayList<Vehicle> getWithMaxSpeed(){
        return VehicleFinder.getWithMaxSpeed(vehicleList);
    }
    public  ArrayList<Vehicle> getWithMinPriceAndMaxSpeedYoungerThanXYears(int ageLimit){
        return VehicleFinder.getWithMinPriceAndMaxSpeedYoungerThanXYears(vehicleList,ageLimit);
    }
}
