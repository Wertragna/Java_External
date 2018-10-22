package com.Homework_11_10_18;



import java.util.Scanner;

/**
 * vehicle!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Controller a = new Controller(new Model(),new View());
        a.fillVehicles();
        a.processUser(new Scanner(System.in));
    }
}
