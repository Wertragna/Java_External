package com.Homework_15_11_18.Controller;

import com.Homework_15_11_18.ProductDao.PcDao;

public class ShowAllPcCommand implements ActionCommand {


    private PcDao pcDAO;

    public ShowAllPcCommand(PcDao pcDAO) {
        this.pcDAO = pcDAO;
    }

    @Override
    public void execute() {
        System.out.println(pcDAO.getAll());
    }
}


