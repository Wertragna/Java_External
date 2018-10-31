package com.Homework_11_10_18;

import com.Homework_11_10_18.Exceptions.IllegalArgumentsOfConsoleException;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class VehicleControllerTest {
    VehicleModel model = new VehicleModel();
    VehicleView view = new VehicleView();
    Scanner scanner = new Scanner(System.in);
    VehicleController vc = new VehicleController(model,view,scanner);

    @Test
    public void chooseMenuItem() {
    }

    @Test
    public void setAndGetResourceBundle() {
    }

    @Test(expected = IllegalArgumentsOfConsoleException.class)
    public void checkHeight_wrongParam() {
        vc.checkHeight(300);
    }

    @Test(expected = IllegalArgumentsOfConsoleException.class)
    public void checkYear_wrongParam() {
        vc.checkYear(1234);
    }

    @Test(expected = IllegalArgumentsOfConsoleException.class)
    public void checkSpeed_wrongParam() {
        vc.checkHeight(50);
    }

    @Test(expected = IllegalArgumentsOfConsoleException.class)
    public void checkAge_wrongParam() {
        vc.checkAge(-5);
    }
}