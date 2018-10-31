package com.Homework_11_10_18;



import java.io.InvalidObjectException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * vehicle!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Plane plane= new Plane.PlaneBuilder(350, 2010,  BigDecimal.valueOf(1000))
                .numberOfPassengers(800)
                .height(13000)
                .build();
        String file = "data\\demo.data";
        ArrayList<Vehicle> a= new ArrayList<>();
        a.add(plane);
        a.add(plane);
        GenericSerialization<ArrayList<Vehicle>> sz = new GenericSerialization();
        GenericSerialization<Vehicle> sv = new GenericSerialization();
        boolean b = sz.serialization(a, file);
        Vehicle res = null;
      /*  try {
          //  res = sv.deserialization(file);
        } catch (InvalidObjectException e) {
            e.printStackTrace();  }
            System.out.println(res);*/

        Scanner scanner = new Scanner(System.in);
        VehicleController vehicleController = new VehicleController(new VehicleModel(),new VehicleView(),scanner);
        vehicleController.processUser();
    }
}
