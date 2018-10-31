package com.Homework_11_10_18;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

public class VehicleFinder {
    public static ArrayList<Vehicle> getPlanesWithHeightMoreThan5000YearOfManufactureAfter2000(List<Vehicle> vehicles) {
        final int YEAR_LIMIT = 2000;
        final int HEIGHT_LIMIT = 5000;

        ArrayList<Vehicle> res = getPlanesWithHeightMoreThanXYearOfManufactureAfterY(vehicles,HEIGHT_LIMIT,YEAR_LIMIT);
        return res;
    }
    public static ArrayList<Vehicle> getPlanesWithHeightMoreThanXYearOfManufactureAfterY(List<Vehicle> vehicles,int xHeignt, int yYears) {
        final int YEAR_LIMIT = yYears;
        final int HEIGHT_LIMIT = xHeignt;

        ArrayList<Vehicle> res = new ArrayList(vehicles);
        res.removeIf(v -> !((v instanceof Plane) && v.getYearOfManufacture()>=YEAR_LIMIT&&((Plane)v).getHeight()>HEIGHT_LIMIT));
        return res;
    }

    static ArrayList <Vehicle> getVehicleWithSpeedBetweenMinAndMax(List<Vehicle> vehicles, int minSpeed, int maxSpeed) {
        final int MAX_SPEED = maxSpeed;
        final int MIN_SPEED = minSpeed;
        ArrayList<Vehicle> filteredVehicles = new ArrayList(vehicles);
        filteredVehicles.removeIf(v -> !(!(v instanceof Plane) && v.getSpeed() >= MIN_SPEED&&v.getSpeed()<=MAX_SPEED));
        return filteredVehicles;
    }
    public static ArrayList <Vehicle> getNotPlaneWithSpeedBetweenXAndY(List<Vehicle> vehicles, int xSpeed, int ySpeed) {
        final int MIN_SPEED = xSpeed;
        final int MAX_SPEED= ySpeed;
        ArrayList<Vehicle> filteredVehicles = getVehicleWithSpeedBetweenMinAndMax(vehicles, MIN_SPEED, MAX_SPEED);
        filteredVehicles.removeIf(v -> !(!(v instanceof Plane)));
        return filteredVehicles;
    }

    static ArrayList <Vehicle> getNotPlaneWithSpeedBetween200And500(ArrayList<Vehicle> vehicles) {
        final int MAX_SPEED = 500;
        final int MIN_SPEED = 200;
        return getNotPlaneWithSpeedBetweenXAndY(vehicles,MIN_SPEED,MAX_SPEED);
    }


    public static ArrayList<Vehicle> getWithMaxSpeed(ArrayList<Vehicle> vehicles) {
        int maxSpeed = vehicles.stream().max(Comparator.comparing(Vehicle::getSpeed)).get().getSpeed();
        ArrayList<Vehicle> filteredVehicles = new ArrayList(vehicles);
        filteredVehicles.removeIf(v -> !(v.getSpeed() == maxSpeed));
        return  filteredVehicles;
    }
    public static ArrayList<Vehicle> getWithMinPriceAndMaxSpeedYoungerThanXYears(List<Vehicle> vehicles, int ageLimit){
        final int AGE_LIMIT = ageLimit;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        BigDecimal minPrice = vehicles.stream().min(Comparator.comparing(Vehicle::getPrice)).get().getPrice();
        int maxSpeed = vehicles.stream().max(Comparator.comparing(Vehicle::getSpeed)).get().getSpeed();
        ArrayList<Vehicle> filteredVehicles = new ArrayList(vehicles);
        filteredVehicles.removeIf(v -> !(v.getSpeed() == maxSpeed
                && v.getPrice().equals(minPrice)
                && currentYear - v.getYearOfManufacture() < AGE_LIMIT));
        return filteredVehicles;
    }
    public static List<Vehicle> getWithMinPriceAndMaxSpeedYoungerThan5Years(List<Vehicle> vehicles){
        final int AGE_LIMIT = 5;
        return getWithMinPriceAndMaxSpeedYoungerThanXYears(vehicles,AGE_LIMIT);
    }

}
