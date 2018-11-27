package com.Homework_22_11_18.command;



import com.Homework_22_11_18.Managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {

        String page = ConfigurationManager.getProperty("path.page.index"); // уничтожение сессии
        request.getSession().invalidate();
        return page;
    }

}
