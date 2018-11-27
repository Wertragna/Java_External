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
import java.util.List;

@WebServlet(urlPatterns = { "/productList"})
public class ProductList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Printer> list = null;
        list = new PrinterDao().getAll();
        request.setAttribute("productList", list);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user.getRole()==2){
            RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/jsp/productListViewAdmin.jsp");
        dispatcher.forward(request, response);}
        else{
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/jsp/productListView.jsp");
            dispatcher.forward(request, response);}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
