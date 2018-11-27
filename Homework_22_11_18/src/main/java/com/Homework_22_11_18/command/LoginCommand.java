package com.Homework_22_11_18.command;


import com.Homework_22_11_18.DAO.UserDAO;
import com.Homework_22_11_18.Logics.LoginLogic;
import com.Homework_22_11_18.Managers.ConfigurationManager;
import com.Homework_22_11_18.Managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.Homework_22_11_18.Managers.ConfigurationManager.*;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {


        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        if(request.getParameter("registration")!=null){
            page = getProperty("path.page.registration");
        }
        else if (  UserDAO.checkByEmailAndPassword(login, pass) != null) {
            request.getSession().setAttribute("user", UserDAO.checkByEmailAndPassword(login, pass) );
            page = getProperty("path.page.main");
        } else {
            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
            page = getProperty("path.page.login");
        }
        return page;

    }
}
