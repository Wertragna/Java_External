package com.Task3;

import com.Task3.generated.Gun;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.Task3.App.logger;
import static com.Task3.Constants.SCHEMA_PATH;


public class MyDOMParser implements MyGunXmlParser {
    public List<Gun.Weapon> getWeaponListFromXml(String pathToXmlFile) {

        List<Gun.Weapon> weapons = new ArrayList<>();
        try {
            ValidGunXml.isValid(pathToXmlFile, SCHEMA_PATH);
            NodeList weaponsList = getWeaponNodesFromFile(pathToXmlFile);
            for (int i = 0; i < weaponsList.getLength(); i++) {
                Node weaponNode = weaponsList.item(i);
                Gun.Weapon currentWeapon = new Gun.Weapon();
                if (weaponNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element tempWeapon = (Element) weaponNode;
                    currentWeapon.setId(tempWeapon.getAttribute("id"));
                    NodeList weaponChildren = tempWeapon.getChildNodes();
                    for (int j = 0; j < weaponChildren.getLength(); j++) {
                        if (weaponChildren.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            Element tempElement = (Element) weaponChildren.item(j);
                            switch (tempElement.getTagName()) {
                                case "model":
                                    currentWeapon.setModel(tempElement.getTextContent());
                                    break;
                                case "handly":
                                    currentWeapon.setHandly(tempElement.getTextContent());
                                    break;
                                case "origin":
                                    currentWeapon.setOrigin(tempElement.getTextContent());
                                    break;
                                case "material":
                                    currentWeapon.setMaterial(tempElement.getTextContent());
                                    break;
                                case "ttc":
                                    NodeList ttcChildren = tempElement.getChildNodes();
                                    Gun.Weapon.Ttc tempTtc = new Gun.Weapon.Ttc();
                                    for (int k = 0; k < ttcChildren.getLength(); k++) {
                                        if (ttcChildren.item(k).getNodeType() == Node.ELEMENT_NODE) {
                                            Element tempTtcChild = (Element) ttcChildren.item(k);
                                            switch (tempTtcChild.getTagName()) {
                                                case "range":
                                                    tempTtc.setRange(tempTtcChild.getTextContent());
                                                    break;
                                                case "sighting_range":
                                                    tempTtc.setSightingRange(Integer.parseInt(tempTtcChild.getTextContent()));
                                                    break;
                                                case "yoke":
                                                    tempTtc.setYoke(Boolean.parseBoolean(tempTtcChild.getTextContent()));
                                                    break;
                                                case "optics":
                                                    tempTtc.setOptics(Boolean.parseBoolean(tempTtcChild.getTextContent()));
                                                    break;
                                            }
                                        }
                                    }
                                    currentWeapon.setTtc(tempTtc);
                                    break;
                            }
                        }
                    }
                    weapons.add(currentWeapon);
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException | JAXBException e) {
            logger.error(e.getMessage());
        }
        return weapons;
    }

    private NodeList getWeaponNodesFromFile(String pathToXmlFile) throws
            SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        db.setErrorHandler(new ConsoleErrorHandler());
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema s = sf.newSchema(new File(SCHEMA_PATH));
        dbf.setValidating(false);
        dbf.setSchema(s);
        Document xmlDoc = db.parse(new File(pathToXmlFile));
        xmlDoc.getDocumentElement().normalize();
        return xmlDoc.getElementsByTagName("weapon");
    }
}
