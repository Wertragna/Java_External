package com.Task3;

import com.Task3.generated.Gun;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.Task3.Constants.SHEMA_PATH;
import static com.Task3.Constants.WEAPON;

public class MyDOMParser {
    public List<Gun.Weapon> getPageListFromXml(String pathToXmlFile) {
        List<Gun.Weapon> weapons = new ArrayList<>();
        try {
            NodeList weaponsList = getWeaponNodesFromFile(pathToXmlFile);
            for (int i = 0; i < weaponsList.getLength(); i++) {
//todo
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return weapons;
    }

    private NodeList getWeaponNodesFromFile(String pathToXmlFile) throws SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        db.setErrorHandler(new ConsoleErrorHandler());
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema s = sf.newSchema(new File(SHEMA_PATH));
        dbf.setValidating(false);
        dbf.setSchema(s);
        Document xmlDoc = db.parse(new File(pathToXmlFile));
        xmlDoc.getDocumentElement().normalize();
        return xmlDoc.getElementsByTagName(WEAPON);
    }

}
