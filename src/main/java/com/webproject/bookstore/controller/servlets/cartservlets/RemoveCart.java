/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.servlets.cartservlets;

import com.webproject.bookstore.controller.services.BookPageServices;
import com.webproject.bookstore.controller.services.ServicesFactory;
import com.webproject.bookstore.controller.services.UserCartServices;
import com.webproject.bookstore.model.dal.dto.BookBean;
import com.webproject.bookstore.model.dal.dto.UserBean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;

/**
 *
 * @author Bishoy
 */
public class RemoveCart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserCartServices cartServices = ServicesFactory.getUserCartServices();
            HttpSession httpSession = req.getSession(false);
            int userId = (int) httpSession.getAttribute("userId");
            int bookId = Integer.parseInt(req.getParameter("bookId"));
            cartServices.removeCartItem(userId, bookId);
            httpSession.setAttribute("userCart", cartServices.getUserCart(userId));
        } catch (HibernateException ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=any");
        }
    }

}
