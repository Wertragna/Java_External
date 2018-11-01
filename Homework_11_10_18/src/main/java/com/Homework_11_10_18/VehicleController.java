package com.Homework_11_10_18;


import com.Homework_11_10_18.Enums.LanguageEnum;
import com.Homework_11_10_18.Enums.MenuItem;
import com.Homework_11_10_18.Exceptions.IllegalArgumentsOfConsoleException;
import com.Homework_11_10_18.Exceptions.IllegalArgumentsOfVehicleException;
import com.Homework_11_10_18.Exceptions.IllegalItemOfMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InvalidObjectException;
import java.util.*;


public class VehicleController {
    VehicleModel model;
    VehicleView view;
    ResourceBundle resourceBundle;
    Scanner scanner;
    private  Locale locale;
    static final String LOCAL_BUNDLE_NAME= "menu";
    final static Logger logger = LogManager.getLogger("VehicleFinder");
    public VehicleController(VehicleModel model, VehicleView view, Scanner scanner) {
        this.scanner= scanner;
        this.model  = model;
        this.view = view;
        fillVehicles();
    }

    public void fillVehicles(){
        try {
            /*model.addVehicle(new Plane.PlaneBuilder(350, 2010, BigDecimal.valueOf(1000))
                    .numberOfPassengers(800)
                    .height(12000)
                    .build()
            );
            model.addVehicle(new Plane.PlaneBuilder(250, 1999, BigDecimal.valueOf(1000000))
                    .numberOfPassengers(800)
                    .height(6000)
                    .build()
            );
            model.addVehicle(new Plane.PlaneBuilder(1100, 2005, BigDecimal.valueOf(20000))
                    .numberOfPassengers(800)
                    .height(6000)
                    .build()
            );
            model.addVehicle(new Ship.ShipBuilder(95, 2001, BigDecimal.valueOf(300000))
                    .numberOfPassengers(800)
                    .port(6000)
                    .build()
            );
            model.addVehicle(new Ship.ShipBuilder(80, 2001, BigDecimal.valueOf(1000000))
                    .numberOfPassengers(800)
                    .port(6000)
                    .build()
            );
            model.addVehicle(new Car(120, 2013, BigDecimal.valueOf(150000)));
            model.addVehicle(new BetMobile(1200, 1985, BigDecimal.valueOf(11111)));
            model.addVehicle(new AmphibiousCar(110, 2018, BigDecimal.valueOf(170000)));
            model.addVehicle(new AmphibiousCar(250, 2018, BigDecimal.valueOf(170000)));*/
            GenericSerialization<ArrayList<Vehicle>> sr = new GenericSerialization<>();
            String file = "data\\vehicles.data";
           // sr.serialization(model.vehicleList, file);
            model.vehicleList = sr.deserialization(file);
           // System.out.println(model.vehicleList.get(0).getClass());
        }
        catch (InvalidObjectException e){
            logger.error(e.getMessage());
        }
        catch (IllegalArgumentsOfVehicleException e){
            logger.error(e.getMessage());
        }
    }

    public void processUser() {
            LocalizeMenu();
            while(true){
                try{
                    view.showMenu();
                    int id = getUserChoice(resourceBundle.getString("label.chooseMenu"));
                    if(!processMenu(chooseMenuItem(id)))
                        break;
                }
                catch (IllegalArgumentException| IllegalItemOfMenu e) {
                    logger.error(e.getMessage());
                }
            }
    }



    public MenuItem chooseMenuItem(int idMenuItem) {
        return MenuItem.getEnum(idMenuItem);
    }

    private boolean processMenu(MenuItem m) {
        int maxSpeed;
        int minSpeed;
        int height;
        int minYear;
        int ageLimit;
        switch (m) {
            case getPlanesWithHeightMoreThanXYearOfManufactureAfterY:
                height = getUserChoice(resourceBundle.getString("input.minHeight"));
                checkHeight(height);
                minYear = getUserChoice( resourceBundle.getString("input.minYear"));
                checkYear(minYear);
                view.pringQueryResults(model.getPlanesWithHeightMoreThanXYearOfManufactureAfterY(height, minYear));
                return true;
            case getNotPlaneWithSpeedBetweenXAndY:
                minSpeed = getUserChoice(resourceBundle.getString("input.minSpeed"));
                checkSpeed(minSpeed);
                maxSpeed = getUserChoice(resourceBundle.getString("input.maxSpeed"));
                checkSpeed(maxSpeed);
                view.pringQueryResults(model.getNotPlaneWithSpeedBetweenXAndY(minSpeed, maxSpeed));
                return true;
            case getWithMaxSpeed:
                view.pringQueryResults(model.getWithMaxSpeed());
                return true;
            case getWithMinPriceAndMaxSpeedYoungerThanXYears:
                ageLimit = getUserChoice(resourceBundle.getString("input.ageLimit"));
                checkAge(ageLimit);
                view.pringQueryResults(model.getWithMinPriceAndMaxSpeedYoungerThanXYears(ageLimit));
                return true;
            case exit:
                return false;
        }
        return false;
    }

    private void LocalizeMenu (){
        String messageOfChooseLanguage = "Choose language/Выберите язык";
        view.printMessage(messageOfChooseLanguage);
        for(LanguageEnum languageEnum:LanguageEnum.values()){
            view.printMessage(languageEnum.toString());
        }
        int id=getUserChoice(messageOfChooseLanguage)  ;
        setAndGetResourceBundle(id);
    }

    public ResourceBundle setAndGetResourceBundle (int id) {
        LanguageEnum language= LanguageEnum.getEnum(id);
        locale = new Locale(language.getLangCode());
        resourceBundle = ResourceBundle.getBundle(LOCAL_BUNDLE_NAME,locale);
        view.setResourceBundle(resourceBundle);
        return resourceBundle;
    }

    private int getUserChoice(String message){
       view.printMessage(message);
        while( ! scanner.hasNextInt()) {
            view.printMessage(resourceBundle.getString("input.error"));
            logger.error(resourceBundle.getString("input.error"));
            view.printMessage(message);
            scanner.next();
        }
        return scanner.nextInt();
    }
    void checkHeight(int param){
        final int HEIGHT_MAX = 100000;
        final int HEIGHT_MIN = 400;
        if(param<=HEIGHT_MIN || param>=HEIGHT_MAX)
            throw new IllegalArgumentsOfConsoleException("The height parameter has inadequate value");
    }

    void checkYear(int param){
        final int YEAR_MAX = Calendar.getInstance().get(Calendar.YEAR);
        final int YEAR_MIN = 1900;
        if(param<=YEAR_MIN || param>=YEAR_MAX)
            throw new IllegalArgumentsOfConsoleException("The year parameter has inadequate value");
    }

    void checkSpeed(int param){
        final int SPEED_MAX = 2000;
        final int SPEED_MIN = 20;
        if(param<=SPEED_MIN || param>=SPEED_MAX)
            throw new IllegalArgumentsOfConsoleException("The speed parameter has inadequate value");
    }

    void checkAge(int param){
        final int AGE_MAX = 100;
        final int AGE_MIN = 0;
        if(param<=AGE_MIN || param>=AGE_MAX)
            throw new IllegalArgumentsOfConsoleException("The age parameter has inadequate value");
    }
}

