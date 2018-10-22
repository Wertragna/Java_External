package com.Homework_11_10_18;

import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Stream;






public class View {
    private static ResourceBundle resourceBundle;
    public void printMessage(String message){
        System.out.println(message);
    }


    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";

    public void pringQueryResults(List<Vehicle> vehicles){
        vehicles.forEach(System.out::println);
    }
    static void setResourceBundle(ResourceBundle resourceBundle) {
        View.resourceBundle = resourceBundle;
    }

    public void showMenu(){
       // for(MenuItem item: MenuItem.values()){
     //       System.out.println(""+item.getId()+" "+item);
     //   }

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
