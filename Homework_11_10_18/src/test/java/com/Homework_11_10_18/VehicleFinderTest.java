package com.Homework_11_10_18;

import org.junit.Assert;
import org.junit.Test;

import java.io.InvalidObjectException;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class VehicleFinderTest {

    ArrayList<Vehicle> vehicles;
    public void fill(){
    try{
        GenericSerialization<ArrayList<Vehicle>> sr= new GenericSerialization<>();
        String file = "data\\vehicles.data";
        vehicles = sr.deserialization(file);
        }
        catch (
             InvalidObjectException e){
        }
    }

    @Test
    public void getPlanesWithHeightMoreThanXYearOfManufactureAfterY_Height700_Year2005_equal() {
        fill();
        ArrayList<Vehicle> expected = new ArrayList<>();
        expected.add( new Plane.PlaneBuilder(350, 2010, BigDecimal.valueOf(1000))
                .numberOfPassengers(800)
                .height(12000)
                .build()
        );
        expected.add(new Plane.PlaneBuilder(1100, 2005, BigDecimal.valueOf(20000))
                .numberOfPassengers(800)
                .height(6000)
                .build()
        );

        assertThat(VehicleFinder.getPlanesWithHeightMoreThanXYearOfManufactureAfterY(vehicles,700,2005),equalTo(expected));
    }

    @Test
    public void getWithMaxSpeed_equal() {
        fill();
        ArrayList<Vehicle> expected = new ArrayList<>();
        expected.add(new BetMobile(1200, 1985, BigDecimal.valueOf(11111)));
        assertThat(VehicleFinder.getWithMaxSpeed(vehicles),equalTo(expected));
    }

}