package com.Homework_08_10_18;

import java.util.ArrayList;
import java.util.List;

public class StarSystem {
    private List<Planet> planets;
    private Star star;
    public StarSystem(String nameStarSytem,Star star) {
        name=nameStarSytem;
        this.star = star;
        planets = new ArrayList<>();
    }

    public List<Planet> getPlanets() {
        return planets;
    }
    public void addPlanet(Planet planet){
        planets.add(planet);
    }

    public String getName() {
        return name;
    }

    private String name;

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result+planets.hashCode();
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
        StarSystem other =(StarSystem) obj;
        if(name == null){
            if(other.name!=null) {
                return false;
            }
        }
        else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@name" + name+"@planets"+planets.toString();
    }
}
