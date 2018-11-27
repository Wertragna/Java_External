package com.Homework_22_11_18;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final Logger logger;

    static {
        logger = Logger.getLogger(App.class);
        DOMConfigurator.configure("log/log4j.xml");
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
