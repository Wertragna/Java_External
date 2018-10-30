package com.Homework_08_10_18;

import java.util.Objects;

public class Moon {
    public Moon(String moonName) {
        name = moonName;
    }
    private String name;
    private  Planet planet;

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
        planet.addMoon(this);
    }

    public String getName() {
        return name;
    }


    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Moon moon = (Moon) o;
        return Objects.equals(name, moon.name);
    }


    @Override
    public String toString() {
        return getClass().getName() + "@name" + name;
    }
}
