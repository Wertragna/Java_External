package com.Homework_15_11_18.Controller;

import com.Homework_15_11_18.ConsoleInputManager;
import com.Homework_15_11_18.ProductDao.ProductDao;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.Homework_15_11_18.App.logger;

public class PrintProductByIdCommand implements ActionCommand{
    private ProductDao productDao;

    public PrintProductByIdCommand(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void execute() {
        System.out.println(productDao.getById(ConsoleInputManager.getStringKeyFromConsole(new BufferedReader(new InputStreamReader(System.in)))));
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getSimpleName());
        return sb.toString();
    }
}
