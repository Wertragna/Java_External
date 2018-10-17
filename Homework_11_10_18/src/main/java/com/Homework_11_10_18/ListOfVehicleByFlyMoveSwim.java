package com.Homework_11_10_18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOfVehicleByFlyMoveSwim {
    public List<Vehicle> flyAbles = new ArrayList<>();
    public List<Vehicle> moveAbles = new ArrayList<>();
    public List<Vehicle> swimAbles = new ArrayList<>();

    @Override
    public String toString() {
        return "ListOfVehicleByFlyMoveSwim{" +
                "flyAbles=" + flyAbles +
                ", moveAbles=" + moveAbles +
                ", swimAbles=" + swimAbles +
                '}';
    }
}
