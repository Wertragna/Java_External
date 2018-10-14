package com.Homework_08_10_18;

public class Star {
    public Star(String starName) {
        name=starName;
    }

    public String getName() {
        return name;
    }

    private String name;

    @Override
    public int hashCode() {
        return name.hashCode();
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
        Star other =(Star)obj;
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
        return getClass().getName() + "@name" + name;
    }
}
