package com.Task081018;

public class Moon {
    public Moon(String moonName, Planet planet) {
        name = moonName;
        this.planet =planet;
    }
    private String name;
    private  Planet planet;

    public String getName() {
        return name;
    }


    @Override
    public int hashCode() {
        return 31*planet.hashCode()+name.hashCode();
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
        Moon other =(Moon) obj;
        if (!name.equals(other.name)) {
            return false;
        }
        if(!planet.equals(other.planet)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@name" + name;
    }
}
