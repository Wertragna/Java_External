package com.Homework_11_10_18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOfVehicleByFlyMoveSwim {
    private List<Vehicle> flyAbles = new ArrayList<>();
    private List<Vehicle> moveAbles = new ArrayList<>();
    private List<Vehicle> swimAbles = new ArrayList<>();

    public List<Vehicle> getFlyAbles() {
        return flyAbles;
    }

    public List<Vehicle> getMoveAbles() {
        return moveAbles;
    }

    public List<Vehicle> getSwimAbles() {
        return swimAbles;
    }

    public ListOfVehicleByFlyMoveSwim(){

    }
    public void addListOfVehicleByWaysOfMoving(List<Vehicle> vehicles) {
        for(Vehicle v: vehicles) {
            addVehicleByWaysOfMoving(v);
        }
    }

    public void addVehicleByWaysOfMoving(Vehicle vehicle) {
        if(vehicle instanceof MoveAble) {
            moveAbles.add(vehicle);
        }
        if(vehicle instanceof SwimAble) {
            swimAbles.add(vehicle);
        }
        if(vehicle instanceof FlyAble) {
            flyAbles.add(vehicle);
        }
    }

    @Override
    public String toString() {
        return "ListOfVehicleByFlyMoveSwim{" +
                "flyAbles=" + flyAbles +
                ", moveAbles=" + moveAbles +
                ", swimAbles=" + swimAbles +
                '}';
    }
}
