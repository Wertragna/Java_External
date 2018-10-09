package com.Task081018;

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
        System.out.println(sun.getName()+", Count of planets: "+starSystem.getPlanets().size()+starSystem.toString());
    }
}
