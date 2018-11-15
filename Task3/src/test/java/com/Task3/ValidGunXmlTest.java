package com.Task3;

import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class ValidGunXmlTest {

    @Test(expected = Exception.class)
    public void isValid() throws JAXBException, SAXException, IOException {
        ValidGunXml.isValid("data/data_wrong.xml",Constants.SCHEMA_PATH);
    }
}