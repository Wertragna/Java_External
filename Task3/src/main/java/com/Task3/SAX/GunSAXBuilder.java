package com.Task3.SAX;

import com.Task3.generated.Gun;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class GunSAXBuilder {

    private List<Gun.Weapon> weapons;
    private WeaponHandler sh;
    private XMLReader reader;

    public GunSAXBuilder() {
        sh = new WeaponHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(sh);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        }
    }

    public List<Gun.Weapon> getWeapons() {
        return weapons;
    }

    public void buildListWeapon(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }
        weapons = sh.getWeapons();
    }
}

