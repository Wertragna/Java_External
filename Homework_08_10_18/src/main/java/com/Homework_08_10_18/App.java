package com.Homework_08_10_18;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
        Planet earth= new Planet("Earth", 1000,2000);
        Star sun = new Star("Sun");
        StarSystem starSystem= new StarSystem("SunStarSystem", sun);
        starSystem.addPlanet(earth);
        Moon moon = new Moon("Moon");
        earth.addMoon(moon);
        System.out.println(moon.getPlanet());
        System.out.println(sun.getName()+", Count of planets: "+starSystem.getPlanets().size()+starSystem.toString());
    }
}
