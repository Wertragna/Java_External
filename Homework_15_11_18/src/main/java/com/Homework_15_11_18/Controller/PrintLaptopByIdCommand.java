package com.Homework_15_11_18.Controller;

import com.Homework_15_11_18.ConsoleInputManager;
import com.Homework_15_11_18.ProductDao.LaptopDao;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.Homework_15_11_18.App.logger;

public class PrintLaptopByIdCommand implements ActionCommand {
    private LaptopDao laptopDao;

    public PrintLaptopByIdCommand(LaptopDao laptopDao) {
        this.laptopDao = laptopDao;
    }

    @Override
    public void execute() {
        try {
            System.out.println(laptopDao.getById(ConsoleInputManager.getKeyFromConsole(new BufferedReader(new InputStreamReader(System.in)))));
        } catch (NumberFormatException e) {
            System.out.println("Wrong input ID!");
            logger.error(e);
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getSimpleName());
        return sb.toString();
    }
}
