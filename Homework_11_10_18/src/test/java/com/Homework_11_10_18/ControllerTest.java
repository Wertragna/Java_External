package com.Homework_11_10_18;

import java.util.Scanner;

public class ControllerTest {
    VehicleModel model = new VehicleModel();
    VehicleView view = new VehicleView();
    Scanner scanner = new Scanner(System.in);
    VehicleController vc = new VehicleController(model,view,scanner);


}
