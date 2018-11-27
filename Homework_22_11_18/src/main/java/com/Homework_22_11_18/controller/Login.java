package com.Homework_22_11_18.controller;

import com.Homework_22_11_18.DAO.UserDAO;
import com.Homework_22_11_18.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.Homework_22_11_18.Managers.ConfigurationManager.getProperty;

@WebServlet(urlPatterns = {"/login-user"}, name = "login")
public class Login extends HttpServlet {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/jsp/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        if (request.getParameter("registration") != null) {
            page = getProperty("path.page.registration");
        } else if (UserDAO.checkByEmailAndPassword(login, pass) != null) {
            request.getSession().setAttribute("user", UserDAO.checkByEmailAndPassword(login, pass));
            page = getProperty("path.page.main");
        }
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);

    }
}
