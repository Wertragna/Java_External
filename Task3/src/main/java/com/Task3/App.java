package com.Task3;

import com.Task3.SAX.MySaxParser;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.DOMConfiguration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static  Logger logger;
    static {
        logger = Logger.getLogger(App.class);
        DOMConfigurator.configure("log/log4j.xml");
    }
    public static void main( String[] args ) {

        MyGunXmlParser parserStax = new MyStAXParser();
        MyGunXmlParser parserDom = new MyDOMParser();
        MyGunXmlParser parserSax = new MySaxParser();

        System.out.println( parserDom.getWeaponListFromXml("data/data.xml"));
        System.out.println(parserSax.getWeaponListFromXml("data/data.xml"));
        System.out.println(parserStax.getWeaponListFromXml("data/data.xml"));
    }
}
