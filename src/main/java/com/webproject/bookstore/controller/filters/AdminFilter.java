package com.webproject.bookstore.controller.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import org.hibernate.HibernateException;

public class AdminFilter implements Filter {

    FilterConfig config;
    RequestDispatcher RD = null;

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            String adminEmail = config.getInitParameter("Email");
            String adminPassword = config.getInitParameter("password");
            String userEmail = request.getParameter("useremail");
            String userPassword = request.getParameter("password");
            System.out.println(adminEmail);
            System.out.println(adminPassword);
            if (adminEmail.equals(userEmail) && adminPassword.equals(userPassword)) {
                RD = request.getRequestDispatcher("admin/index.jsp");
                RD.forward(request, response);
                //chain.doFilter(request, response);
            } else {
                chain.doFilter(request, response);
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
            ((HttpServletResponse)response).sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            ((HttpServletResponse)response).sendRedirect("error.jsp?ex=any");
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        this.config = arg0;
    }

}
