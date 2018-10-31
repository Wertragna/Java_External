package com.Homework_11_10_18;

import com.Homework_11_10_18.Enums.MenuItem;
import com.Homework_11_10_18.Exceptions.IllegalItemOfMenu;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuItemTest {

    @Test
    public void getEnum_correctMenuItem_returnMenuItem() {
        int id =2;
        MenuItem menuItem= MenuItem.getEnum(id);
        assertEquals(MenuItem.getNotPlaneWithSpeedBetweenXAndY,menuItem);
    }
    @Test(expected = IllegalItemOfMenu.class)
    public void getEnum_wrongMenuItem_returnMenuItem() {
        int id =10;
        MenuItem menuItem= MenuItem.getEnum(id);
    }
}