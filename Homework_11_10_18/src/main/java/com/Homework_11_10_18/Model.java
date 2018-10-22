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
