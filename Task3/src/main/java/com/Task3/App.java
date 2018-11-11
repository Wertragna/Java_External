package com.Task3;

import com.Task3.SAX.GunSAXBuilder;
import com.Task3.generated.Gun;
import com.sun.org.apache.xpath.internal.operations.Variable;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        /*String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String schemaName = "data/gun.xsd";
        File schemaLocation = new File(schemaName);
        System.out.println(ValidGunXml.isValid("data/data.xml", schemaName));*/

        GunSAXBuilder gunSAXBuilder = new GunSAXBuilder();
        gunSAXBuilder.buildListWeapon("data/data.xml");
        System.out.println (gunSAXBuilder.getWeapons());
    }
}
