package com.Homework_15_11_18.Controller;

import com.Homework_15_11_18.ProductDao.LaptopDao;
import com.Homework_15_11_18.ProductDao.PcDao;
import com.Homework_15_11_18.ProductDao.PrinterDao;
import com.Homework_15_11_18.ProductDao.ProductDao;

public class ConsoleMenuFactory {
    public static MenuProductController getMenuController(){
        MenuProductController menuController = new MenuProductController();

        menuController.setCommand(0, new PrintAllCommand(new LaptopDao()));
        menuController.setCommand(1, new PrintAllCommand(new PcDao()));
        menuController.setCommand(2, new PrintAllCommand(new PrinterDao()));
        menuController.setCommand(3, new PrintAllCommand(new ProductDao()));
        menuController.setCommand(4, new PrintLaptopByIdCommand(new LaptopDao()));
        menuController.setCommand(5, new PrintProductByIdCommand(new ProductDao()));
        menuController.setCommand(6, new PrintPrinterByIdCommand(new PrinterDao()));
        menuController.setCommand(7, new PrintPcByIdCommand(new PcDao()));

        return menuController;
    }

}
