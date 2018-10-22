package com.Homework_11_10_18;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;



public class Controller {
    // Constructor
    Model model;
    View view;
    ResourceBundle resourceBundle;
    private  Locale locale;
    static final String LOCAL_BUNDLE_NAME= "menu";
    final Logger logger = LogManager.getLogger("VehicleFinder");
    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    public void fillVehicles(){
        try{
            model.addVehicle(new Plane.PlaneBuilder(350, 2010,  BigDecimal.valueOf(1000))
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
            model.addVehicle(new AmphibiousCar(250, 2018, BigDecimal.valueOf(170000)));
        }
        catch (IllegalArgumentsOfVehicleException e){
            logger.error(e.getMessage());
        }
    }
    // The Work method
    public void processUser(Scanner sr)        {
            Scanner sc = new Scanner(System.in);
            LocalizeMenu(sr);
            while(isNotExit(sr)) {
            }
    }


    private boolean isNotExit(Scanner sr){
        try{
            return menu(sr);
        }
        catch (IllegalArgumentsOfConsoleException e) {
            logger.error(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
        }
        catch (IllegalItemOfMenu e){
            logger.error(e.getMessage());
        }

        return true;
    }
    private boolean menu(Scanner sr) {
        int maxSpeed;
        int minSpeed;
        int height;
        int minYear;
        int ageLimit;
        view.showMenu();
        MenuItem m = MenuItem.getEnum(getUserChoice(sr, resourceBundle.getString("label.chooseMenu")));
        switch (m) {
            case getPlanesWithHeightMoreThanXYearOfManufactureAfterY:
                height = getUserChoice(sr, resourceBundle.getString("input.minHeight"));
                checkHeight(height);
                minYear = getUserChoice(sr, resourceBundle.getString("input.minYear"));
                checkYear(minYear);
                view.pringQueryResults(model.getPlanesWithHeightMoreThanXYearOfManufactureAfterY(height, minYear));
                return true;
            case getNotPlaneWithSpeedBetweenXAndY:
                minSpeed = getUserChoice(sr, resourceBundle.getString("input.minSpeed"));
                checkSpeed(minSpeed);
                maxSpeed = getUserChoice(sr, resourceBundle.getString("input.maxSpeed"));
                checkSpeed(maxSpeed);
                view.pringQueryResults(model.getNotPlaneWithSpeedBetweenXAndY(minSpeed, maxSpeed));
                return true;
            case getWithMaxSpeed:
                view.pringQueryResults(model.getWithMaxSpeed());
                return true;
            case getWithMinPriceAndMaxSpeedYoungerThanXYears:
                ageLimit = getUserChoice(sr, resourceBundle.getString("input.ageLimit"));
                checkAge(ageLimit);
                view.pringQueryResults(model.getWithMinPriceAndMaxSpeedYoungerThanXYears(ageLimit));
                return true;
            case exit:
                return false;
        }
        return false;
    }

    private void LocalizeMenu (Scanner st){
        String messageOfChooseLanguage = "Choose language/Выберите язык/Оберіть мову";
        resourceBundle = ResourceBundle.getBundle(LOCAL_BUNDLE_NAME,new Locale("en"));
        view.printMessage(messageOfChooseLanguage);
        for(LanguageEnum languageEnum:LanguageEnum.values()){
            System.out.println(languageEnum);
        }
        LanguageEnum language= LanguageEnum.getEnum(getUserChoice(st,messageOfChooseLanguage));
        locale = new Locale(language.getLangCode());

        resourceBundle = ResourceBundle.getBundle(LOCAL_BUNDLE_NAME,locale);
       // System.out.println(resourceBundle.getLocale());
        view.setResourceBundle(resourceBundle);
    }

    private int getUserChoice(Scanner sc, String message){
       view.printMessage(message);
        while( ! sc.hasNextInt()) {
            view.printMessage(resourceBundle.getString("input.error"));
            logger.error(resourceBundle.getString("input.error"));
            view.printMessage(message);
            sc.next();
        }
        return sc.nextInt();
    }
    private void checkHeight(int param){
        final int HEIGHT_MAX = 100000;
        final int HEIGHT_MIN = 500;
        if(param<=HEIGHT_MIN || param>=HEIGHT_MAX)
            throw new IllegalArgumentsOfConsoleException("The height parameter has inadequate value");
    }

    private void checkYear(int param){
        final int YEAR_MAX = Calendar.getInstance().get(Calendar.YEAR);
        final int YEAR_MIN = 1900;
        if(param<=YEAR_MIN || param>=YEAR_MAX)
            throw new IllegalArgumentsOfConsoleException("The year parameter has inadequate value");
    }

    private void checkSpeed(int param){
        final int SPEED_MAX = 2000;
        final int SPEED_MIN = 20;
        if(param<=SPEED_MIN || param>=SPEED_MAX)
            throw new IllegalArgumentsOfConsoleException("The speed parameter has inadequate value");
    }

    private void checkAge(int param){
        final int AGE_MAX = 100;
        final int AGE_MIN = 0;
        if(param<=AGE_MIN || param>=AGE_MAX)
            throw new IllegalArgumentsOfConsoleException("The age parameter has inadequate value");
    }
}

