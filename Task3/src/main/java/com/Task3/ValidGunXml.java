package com.Task3;

import com.Task3.generated.Gun;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidGunXml {
    public static void isValid(String fileName, String schemaName) throws IOException, SAXException, JAXBException {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        Schema schema = null;
        schema = factory.newSchema(schemaLocation);
        Validator validator = schema.newValidator();
        Source source = new StreamSource(fileName);
        JAXBContext jc = JAXBContext.newInstance(Gun.class);
        validator.validate(source);
    }
}
