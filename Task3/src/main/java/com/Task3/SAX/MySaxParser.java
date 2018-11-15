package com.Task3.SAX;

import com.Task3.MyGunXmlParser;
import com.Task3.ValidGunXml;
import com.Task3.generated.Gun;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

import static com.Task3.App.logger;
import static com.Task3.Constants.SCHEMA_PATH;


public class MySaxParser implements MyGunXmlParser {

    private List<Gun.Weapon> weapons;
    private WeaponHandler sh;
    private XMLReader reader;

    public MySaxParser() {
        sh = new WeaponHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(sh);
        } catch (SAXException e) {
            logger.error(e.getMessage());
        }
    }

    public List<Gun.Weapon> getWeaponListFromXml(String pathToXmlFile) {
        try {
            reader.parse(pathToXmlFile);
        } catch (SAXException|IOException e) {
            logger.error(e.getMessage());
        }
        return sh.getWeapons();
    }
}

