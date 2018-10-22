package com.Homework_11_10_18;

import java.util.stream.Stream;

public enum MenuItem {
        getPlanesWithHeightMoreThanXYearOfManufactureAfterY(1),
        getNotPlaneWithSpeedBetweenXAndY(2),
        getWithMaxSpeed(3),
        getWithMinPriceAndMaxSpeedYoungerThanXYears(4),
        exit(5);
        MenuItem(int id){
            this.id = id;
        }
        public int id;

        public int getId() {
            return id;
        }
        public static com.Homework_11_10_18.MenuItem getEnum(int value) {
            for(com.Homework_11_10_18.MenuItem v : values())
                if(v.getId()==value)
                    return v;
            throw new IllegalItemOfMenu("Wrong menu item.");
        }
    }

