package com.Homework_22_11_18.Logics;


import com.Homework_22_11_18.DAO.UserDAO;

public class LoginLogic {
    private final static String ADMIN_LOGIN = "admin";
    private final static String ADMIN_PASS = "Qwe123";

    public static boolean checkLogin(String enterLogin, String enterPass) {

       return UserDAO.checkByEmailAndPassword(enterLogin, enterPass) != null;

    }
}


