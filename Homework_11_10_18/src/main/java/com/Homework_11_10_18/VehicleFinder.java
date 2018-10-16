package com.Homework_11_10_18;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

public class VehicleFinder {
    public static List<Vehicle> getPlanesWithHeightMoreThan5000YearOfManufactureAfter2000(List<Vehicle> vehicles){
        final int YEAR_LIMIT = 2000;
        final int HEIGHT_LIMIT = 5000;

        List<Vehicle> res = new ArrayList(vehicles);
        res.removeIf(v -> !((v instanceof Plane) && v.getYearOfManufactured()>=YEAR_LIMIT&&((Plane)v).getHeight()>HEIGHT_LIMIT));
        return res;
    }

    public static List <Vehicle> getNotPlaneWithSpeedBetween200And500(List<Vehicle> vehicles){
        final int MAX_SPEED = 500;
        final int MIN_SPEED = 200;

        List<Vehicle> res = new ArrayList(vehicles);
        res.removeIf(v -> !(!(v instanceof Plane) && v.getSpeed()>=MIN_SPEED&&v.getSpeed()<=MAX_SPEED));
        return res;
    }

    public static ListOfVehicleByFlyMoveSwim getFilteredByWaysOfMOving(List<Vehicle> vehicles){
        ListOfVehicleByFlyMoveSwim filteredResult = new ListOfVehicleByFlyMoveSwim();
        for(Vehicle v:vehicles){
            if(v instanceof MoveAble)
                filteredResult.moveAbles.add((MoveAble) v);
            if(v instanceof SwimAble)
                filteredResult.swimAbles.add((SwimAble) v);
            if(v instanceof FlyAble)
                filteredResult.flyAbles.add((FlyAble) v);
        }
        return filteredResult;
    }

    public static List<Vehicle> getWithMaxSpeed(List<Vehicle> vehicles){
        int maxSpeed = vehicles.stream().max(Comparator.comparing(Vehicle::getSpeed)).get().getSpeed();
        List<Vehicle> res = new ArrayList();
        res.removeIf(v->!(v.getSpeed()==maxSpeed));
        return  res;
    }

    public static List<Vehicle> getWithMinPriceAndMaxSpeedYoungerThan5Years(List<Vehicle> vehicles){
        final int AGE_LIMIT = 5;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        BigDecimal minPrice = vehicles.stream().min(Comparator.comparing(Vehicle::getPrice)).get().getPrice();
        int maxSpeed = vehicles.stream().max(Comparator.comparing(Vehicle::getSpeed)).get().getSpeed();
        List<Vehicle> res = new ArrayList();
        res.removeIf(v->!(v.getSpeed()==maxSpeed&&v.getPrice().equals(minPrice)&&currentYear-v.getYearOfManufactured()<AGE_LIMIT));
        return res;
    }

}
