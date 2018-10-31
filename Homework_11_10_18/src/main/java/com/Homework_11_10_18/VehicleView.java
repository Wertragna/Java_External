package com.Homework_11_10_18;

import java.util.List;
import java.util.ResourceBundle;


public class VehicleView {
    private static ResourceBundle resourceBundle;
    public void printMessage(String message){
        System.out.println(message);
    }
    public void pringQueryResults(List<Vehicle> vehicles){
        vehicles.forEach(System.out::println);
    }
    static void setResourceBundle(ResourceBundle resourceBundle) {
        VehicleView.resourceBundle = resourceBundle;
    }

    public void showMenu(){
        System.out.println(resourceBundle.getString("label.menuItem1"));
        System.out.println(resourceBundle.getString("label.menuItem2"));
        System.out.println(resourceBundle.getString("label.menuItem3"));
        System.out.println(resourceBundle.getString("label.menuItem4"));
        System.out.println(resourceBundle.getString("label.menuExit"));
    }

    public void showItem( Object obj){
        System.out.println(obj);
    }
}
