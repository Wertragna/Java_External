package com.Homework_11_10_18;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    static List<Vehicle> vehicles = new ArrayList<>();
    public static void main( String[] args ) {
        fillVehicles();

        System.out.println("Query 1:");
        List<Vehicle> query = VehicleFinder.getPlanesWithHeightMoreThan5000YearOfManufactureAfter2000(vehicles);
        query.forEach(n-> System.out.println(n));

        System.out.println("Query 2:");
        query = VehicleFinder.getPlaneWithSpeedBetween200And500(vehicles);
        query.forEach(n-> System.out.println(n));

        ListOfVehicleByFlyMoveSwim query3 = VehicleFinder.getFilteredByWaysOfMoving(vehicles);
        System.out.println(query3);

        query = VehicleFinder.getWithMaxSpeed(query3.flyAbles);
        System.out.println("Flyable with maximal speed:");
        query.forEach(n-> System.out.println(n));
        query = VehicleFinder.getWithMaxSpeed(query3.moveAbles);
        System.out.println("Flyable with maximal moveable:");
        query.forEach(n-> System.out.println(n));
        query = VehicleFinder.getWithMaxSpeed(query3.swimAbles);
        System.out.println("Swimable with maximal speed:");
        query.forEach(n-> System.out.println(n));
    }

    private static void fillVehicles(){
        vehicles.add(new Plane.PlaneBuilder(350, 2010, BigDecimal.valueOf(1000))
                .numberOfPassengers(800)
                .height(12000)
                .build()
        );
        vehicles.add(new Plane.PlaneBuilder(250, 1999, BigDecimal.valueOf(1000000))
                .numberOfPassengers(800)
                .height(6000)
                .build()
        );
        vehicles.add(new Plane.PlaneBuilder(1100, 2005, BigDecimal.valueOf(20000))
                .numberOfPassengers(800)
                .height(6000)
                .build()
        );
        vehicles.add(new Ship.ShipBuilder(95, 2001, BigDecimal.valueOf(300000))
                .numberOfPassengers(800)
                .port(6000)
                .build()
        );
        vehicles.add(new Ship.ShipBuilder(80, 2001, BigDecimal.valueOf(1000000))
                .numberOfPassengers(800)
                .port(6000)
                .build()
        );
        vehicles.add(new Car(120, 2013, BigDecimal.valueOf(150000)));
        vehicles.add(new BetMobile(1200, 1985, BigDecimal.valueOf(11111)));
        vehicles.add(new AmphibiousCar(110, 2018, BigDecimal.valueOf(170000)));
        vehicles.add(new AmphibiousCar(250, 2018, BigDecimal.valueOf(170000)));
    }
}
