package com.Homework_08_10_18;

import java.util.*;

public class Planet {

    private double massKg;
    private double radiusKm;
    final double EPS = Math.pow(10,-5);
    private String name;

    Set <Moon> moons;

    public Planet(String planetName, double massKg, double radiusKm) {
        name = planetName;
        this.massKg=massKg;
        this.radiusKm= radiusKm;
        moons= new HashSet<>();
    }
    public String getName() {
        return name;
    }



    public void addMoon(Moon moon){
        moons.add(moon);
        if(!this.equals(moon.getPlanet())){
            moon.setPlanet(this);
        }
    }

    public Set<Moon> getMoons() {
        return moons;
    }

    @Override
    public int hashCode() {
       int result = 17;
       long massLong= Double.doubleToLongBits(massKg);
       int massInt = (int)(massLong^(massLong>>>32));
       long radiusLong= Double.doubleToLongBits(radiusKm);
       int  radiusInt = (int)(radiusLong^(massLong>>>32));
       result = 31*result+massInt;
       result = 31*result+radiusInt;
       result = 31*result+name.hashCode();
       return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj==null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Planet other =(Planet)obj;
        if(name == null){
            if(other.name!=null) {
                return false;
            }
        }
        else if (!name.equals(other.name)) {
            return false;
        }
        if (Math.abs(radiusKm-other.radiusKm)<EPS) {
            return false;
        }
        if (Math.abs(massKg-other.massKg)<EPS) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@name" + name+"@mass(kg):"+ massKg+"@radius(km)"+radiusKm;
    }
}
