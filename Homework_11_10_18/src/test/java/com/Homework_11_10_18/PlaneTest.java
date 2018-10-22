package com.Homework_11_10_18;

import org.junit.*;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;


public class PlaneTest {
    static Plane  plane;
    private static final int HEIGHT=2000;
    private static final int HEIGHT_WRONG= 10;
    @Before
    public void init(){
        plane = new Plane.PlaneBuilder(250, 1999, BigDecimal.valueOf(1000000))
        .height(HEIGHT)
        .build();
    }

    @Test
    public void getHeight(){
        int actualHeight=plane.getHeight();
        int expectedHeight = HEIGHT;
        assertEquals(expectedHeight,actualHeight);
    }

    @Test (expected = IllegalArgumentsOfVehicleException.class)
    public void buildPlaneWithWrongHeight(){
        plane= new Plane.PlaneBuilder(250, 1999, BigDecimal.valueOf(1000000))
                .height(HEIGHT_WRONG)
                .build();
    }
    @After
    public  void  clean(){
        plane = null;
    }
}
