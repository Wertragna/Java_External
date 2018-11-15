package com.Task3.SAX;

import com.Task3.generated.Gun;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class WeaponHandler extends DefaultHandler {
    private List<Gun.Weapon> weapons = new ArrayList<>();
    private Gun.Weapon current = new Gun.Weapon();
    private Gun.Weapon.Ttc ttc = new Gun.Weapon.Ttc();
    private String currentElem;

    private boolean isModel = false;
    private boolean isHandly = false;
    private boolean isOrigin = false;
    private boolean isMaterial = false;
    private boolean isSightingRange = false;
    private boolean isYoke = false;
    private boolean isOptics = false;
    private boolean isRange = false;

    public List<Gun.Weapon> getWeapons() {
        return weapons;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElem = qName;
        if (qName.equalsIgnoreCase("weapon")) {
            String id = attributes.getValue("id");
             current.setId(id);
        } else if (qName.equals("model")) {
            isModel = true;
        } else if (qName.equals("handly")) {
            isHandly = true;
        } else if (qName.equals("origin")) {
            isOrigin = true;
        } else if (qName.equals("material")) {
            isMaterial = true;
        } else if (qName.equals("range")) {
            isRange = true;
        } else if (qName.equals("optics")) {
            isOptics = true;
        } else if (qName.equals("sighting_range")) {
            isSightingRange= true;
        } else if (qName.equals("yoke")) {
            isYoke = true;
        }


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("ttc".equals(localName)) {
            current.setTtc(ttc);
        }
        if ("weapon".equals(localName)) {
            weapons.add(current);
            current = new Gun.Weapon();
            ttc = new Gun.Weapon.Ttc();
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        switch (currentElem) {
            case "model":
                if (isModel) {
                    current.setModel(new String(ch, start, length));
                    isModel = false;
                }
                break;
            case "handly":
                if (isHandly) {
                    current.setHandly(new String(ch, start, length));
                    isHandly = false;
                }
                break;
            case "origin":
                if (isOrigin) {
                    current.setOrigin(new String(ch, start, length));
                    isOrigin = false;
                }
                break;
            case "material":
                if (isMaterial) {
                    String a = new String(ch, start, length);
                    current.setMaterial(new String(ch, start, length));
                    isMaterial = false;
                }
                break;
            case "range":
                if (isRange) {
                    ttc.setRange(new String(ch, start, length));
                    isRange = false;
                }
                break;
            case "sighting_range":
                if (isSightingRange) {
                    ttc.setSightingRange(Integer.parseInt(new String(ch, start, length)));
                    isSightingRange = false;
                }
                break;
            case "yoke":
                if (isYoke) {
                    ttc.setYoke(Boolean.parseBoolean(new String(ch, start, length)));
                    isYoke = false;
                }
                break;
            case "optics":
                if (isOptics) {
                    ttc.setOptics(Boolean.parseBoolean(new String(ch, start, length)));
                    isOptics = false;
                }
                break;
        }
    }
}


