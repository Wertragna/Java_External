package com.Homework_22_11_18.controller;

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


@WebServlet(urlPatterns = {"/userInfo"}, name = "userInfo")
public class UserInfo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String page = page = "/jsp/userInfo.jsp";
        String command = req.getParameter("command");
        req.setAttribute("user", user.getLogin());
        if (command != null) {
            if (command.equals("logout")) {
                session.invalidate();
                page = getProperty("path.page.main");
            }
        }

        RequestDispatcher dispatcher = req.getServletContext()
                .getRequestDispatcher(page);
        dispatcher.forward(req, resp);
    }
}
