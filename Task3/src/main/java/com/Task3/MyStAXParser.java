package com.Task3;

import com.Task3.generated.Gun;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.Task3.App.logger;
import static com.Task3.Constants.SCHEMA_PATH;

public class MyStAXParser implements MyGunXmlParser{

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

    public List<Gun.Weapon> getWeaponListFromXml(String pathToXmlFile)  {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            ValidGunXml.isValid(pathToXmlFile, SCHEMA_PATH);
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(pathToXmlFile));
            while (xmlEventReader.hasNext()) {
                XMLEvent currentEvent = xmlEventReader.nextEvent();
                if (currentEvent.isStartElement()) {
                    StartElement startElement = currentEvent.asStartElement();
                    currentElem = startElement.getName().getLocalPart();
                    if (currentElem.equals("weapon")) {
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if (idAttr != null) {
                            current.setId(idAttr.getValue());
                        }
                    } else if (currentElem.equals("model")) {
                        currentEvent = xmlEventReader.nextEvent();
                        current.setModel(currentEvent.asCharacters().getData());
                    } else if (currentElem.equals("handly")) {
                        currentEvent = xmlEventReader.nextEvent();
                        current.setHandly(currentEvent.asCharacters().getData());
                    }else if (currentElem.equals("material")) {
                        currentEvent = xmlEventReader.nextEvent();
                        current.setMaterial(currentEvent.asCharacters().getData());
                    } else if (currentElem.equals("origin")) {
                        currentEvent = xmlEventReader.nextEvent();
                        current.setOrigin(currentEvent.asCharacters().getData());
                    } else if (currentElem.equals("ttc")) {
                        current.setTtc(getXMLAddress(xmlEventReader));
                    }
                }

                 else if (currentEvent.isEndElement()&&currentEvent.asEndElement().getName().getLocalPart().equals("weapon")) {
                    weapons.add(current);
                    current = new Gun.Weapon();
                }
            }
        } catch (XMLStreamException  | IOException |JAXBException|SAXException e) {
            logger.error(e.getMessage());
        }
        return weapons;
    }

    private Gun.Weapon.Ttc getXMLAddress(XMLEventReader xmlEventReader) throws XMLStreamException {
        Gun.Weapon.Ttc ttc = new Gun.Weapon.Ttc();
        int type;
        String name;
        XMLEvent currentEvent = xmlEventReader.nextEvent();
        while (xmlEventReader.hasNext()) {
            currentEvent = xmlEventReader.nextEvent();
            if (currentEvent.isStartElement()) {
                StartElement startElement = currentEvent.asStartElement();
                currentElem = startElement.getName().getLocalPart();

                switch (currentElem) {
                    case "range":
                        currentEvent = xmlEventReader.nextEvent();
                        ttc.setRange(currentEvent.asCharacters().getData());
                        break;
                    case "sighting_range":
                        currentEvent = xmlEventReader.nextEvent();
                        ttc.setSightingRange(Integer.parseInt(currentEvent.asCharacters().getData()));
                        break;
                    case "yoke":
                        currentEvent = xmlEventReader.nextEvent();
                        ttc.setYoke(Boolean.parseBoolean(currentEvent.asCharacters().getData()));
                        break;
                    case "optics":
                        currentEvent = xmlEventReader.nextEvent();
                        ttc.setOptics(Boolean.parseBoolean(currentEvent.asCharacters().getData()));
                        break;
                }
            }
                else if (currentEvent.isEndElement()&&currentEvent.asEndElement().getName().getLocalPart().equals("ttc")) {
                    return ttc;
                }

        }
        throw new XMLStreamException("Unknown element in tag Address");
    }
}
