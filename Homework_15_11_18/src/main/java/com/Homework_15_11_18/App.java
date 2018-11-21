package com.Homework_15_11_18;

import com.Homework_15_11_18.Controller.ConsoleMenuFactory;
import com.Homework_15_11_18.Controller.MenuProductController;
import com.Homework_15_11_18.ProductDao.PcDao;
import com.Homework_15_11_18.ProductDao.ProductDao;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 *
 */
public class App 
{
    private static BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
    public static final Logger logger;

    static {
        logger = Logger.getLogger(App.class);
        DOMConfigurator.configure("log/log4j.xml");
    }

    public static void main(String[] args )
    {
        MenuProductController menuController = ConsoleMenuFactory.getMenuController();
        processUser(menuController);
    }

    public static void processUser(MenuProductController menuController){
        while (true) {
            System.out.println(menuController.toString());
            try {
                menuController.menuItemPickedUp(getMenuItemChoice());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static int getMenuItemChoice() throws IOException {
        System.out.print("Choose menu item:");
        return Integer.parseInt(scanner.readLine());
    }

}
