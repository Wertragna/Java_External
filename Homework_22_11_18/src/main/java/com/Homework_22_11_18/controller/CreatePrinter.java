package com.Homework_22_11_18.controller;

import com.Homework_22_11_18.DAO.PrinterDao;
import com.Homework_22_11_18.model.Printer;
import com.Homework_22_11_18.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(urlPatterns = {"/productList/createPrinter"}, name = "createPrinter")
public class CreatePrinter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user.getRole() == 2) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/jsp/createPrintView.jsp");
            dispatcher.forward(request, response);
        }
        else
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

    // Когда пользователь вводит информацию продукта, и нажимает Submit.
    // Этот метод будет вызван.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String codeStr = (String) request.getParameter("code");
        String model = (String) request.getParameter("model");
        String priceStr = (String) request.getParameter("price");
        String color = (String) request.getParameter("color");
        String type = (String) request.getParameter("type");
        BigDecimal price = new BigDecimal(priceStr);

        Printer printer = new Printer();
        int code = Integer.parseInt(codeStr);
        printer.setCode(code);
        printer.setColor(color);
        printer.setModel(model);
        printer.setPrice(price);
        printer.setType(type);
        String errorString = null;
        System.out.println(printer);
        new PrinterDao().create(printer);
        // Кодом продукта является строка [a-zA-Z_0-9]
        // Имеет минимум 1 символ.
        String regex = "\\w+";


        if (errorString == null) {

        }

        // Сохранить информацию в request attribute перед тем как forward к views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", printer);

        // Если имеется ошибка forward (перенаправления) к странице 'edit'.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
            dispatcher.forward(request, response);
        }
        // Если все хорошо.
        // Redirect (перенаправить) к странице со списком продуктов.
        else {
            response.sendRedirect(request.getContextPath() + "/productList");
        }
    }
}
