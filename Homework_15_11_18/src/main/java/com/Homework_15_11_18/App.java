package com.Homework_15_11_18;

import com.Homework_15_11_18.ProductDao.ProductDao;
import com.Homework_15_11_18.ProductModel.Product;
import com.mysql.fabric.jdbc.FabricMySQLDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
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


    }
}
