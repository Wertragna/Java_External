package com.Homework_22_11_18.controller;

import com.Homework_22_11_18.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

import java.io.IOException;

import static java.util.Objects.nonNull;

@WebFilter(urlPatterns = { "/productList/*","/userInfo/*"}  )
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)

            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        //Logged user.
        if (nonNull(session) &&nonNull(user)) {
            filterChain.doFilter(request, response);
        }  else {
            res.sendRedirect("/product/login-user");
        }
    }

    @Override
    public void destroy() {

    }

}
