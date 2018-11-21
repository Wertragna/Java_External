package com.Homework_15_11_18.Controller;

import com.Homework_15_11_18.ProductDao.Dao;

public class PrintAllCommand implements ActionCommand {
    private Dao dao;

    public PrintAllCommand(Dao dao) {
        this.dao=dao;
    }

    @Override
    public void execute() {
        System.out.println(dao.getAll());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getSimpleName());
        sb.append(" ").append(dao.getClass().getSimpleName().replace("Dao",""));
        return sb.toString();
    }
}
