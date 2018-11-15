package com.Task3.SAX;

import com.Task3.generated.Gun;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class MySaxParserTest {
    MySaxParser mySaxParse;
    static String pathToXml= "data/data.xml";
    @Before
    public void setUp() throws Exception {
        mySaxParse = new MySaxParser();
    }

    @Test
    public void getWeaponListFromXml_correctXML_correctList() {
        Assert.assertThat(mySaxParse.getWeaponListFromXml(pathToXml),equalTo(listOfWeapon()));
    }

    private List<Gun.Weapon> listOfWeapon(){
        List<Gun.Weapon> weapons =new ArrayList<>();
        Gun.Weapon weapon = new Gun.Weapon();
        weapon.setId("ID-2");
        weapon.setMaterial("metal");
        weapon.setModel("model3");
        weapon.setHandly("one");
        weapon.setOrigin("China");
        Gun.Weapon.Ttc ttc = new Gun.Weapon.Ttc();
        ttc.setOptics(true);
        ttc.setYoke(true);
        ttc.setSightingRange(9);
        ttc.setRange("close");
        weapon.setTtc(ttc);
        weapons.add(weapon);

        weapon = new Gun.Weapon();
        ttc = new Gun.Weapon.Ttc();
        weapon.setId("ID-1");
        weapon.setMaterial("materialX");
        weapon.setModel("model1");
        weapon.setHandly("one");
        weapon.setOrigin("Ukraine");
         ttc = new Gun.Weapon.Ttc();
        ttc.setOptics(true);
        ttc.setYoke(true);
        ttc.setSightingRange(10);
        ttc.setRange("close");
        weapon.setTtc(ttc);

        weapons.add(weapon);
        return weapons;
    }

    @After
    public void tearDown() throws Exception {
        mySaxParse = null;
    }
}