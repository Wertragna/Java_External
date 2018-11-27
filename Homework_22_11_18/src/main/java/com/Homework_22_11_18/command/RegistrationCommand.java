package com.Homework_22_11_18.command;

import com.Homework_22_11_18.DAO.UserDAO;
import com.Homework_22_11_18.Managers.ConfigurationManager;
import com.Homework_22_11_18.model.User;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements ActionCommand {
    private static final String PARAM_NAME_EMAIL = "login";
    private static final String PARAM_NAME_PASSWORD = "password";


    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_EMAIL);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        //if (LoginLogic.checkLogin(login, pass)) {
        User user= new User();
        user.setLogin(login);
        user.setRole(1);
        user.setPassword(pass);
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.create(user));
        request.setAttribute("user", login);
        page = ConfigurationManager.getProperty("path.page.main");
       // } else {
          //  request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
          //  page = ConfigurationManager.getProperty("path.page.login");
       // }
        return page;
    }
}
