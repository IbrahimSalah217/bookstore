/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.servlets.cartservlets;

import com.webproject.bookstore.controller.services.UserCartServices;
import java.io.IOException;
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
public class UpdateCart extends HttpServlet {
    
    UserCartServices cartServices = new UserCartServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{HttpSession httpSession = req.getSession(false);
        int userId = (int) httpSession.getAttribute("userId");
        String bookId = req.getParameter("id");        
        int bookIdInt = Integer.parseInt(bookId);
        System.out.println(bookIdInt);
        cartServices.addToCart(userId, bookIdInt, 1);
        httpSession.setAttribute("userCart", cartServices.getUserCart(userId));
        resp.sendRedirect("LoadCartServlet");
        }catch (HibernateException ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=any");
        } 
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{HttpSession httpSession = req.getSession(false);
        String quantity = req.getParameter("quantity");
        int quantityInt = Integer.parseInt(quantity);
        int userId = (int) httpSession.getAttribute("userId");
        String bookId = req.getParameter("bookId");
        int bookIdInt = Integer.parseInt(bookId);
        System.out.println(bookIdInt);
        System.out.println(bookIdInt);
        cartServices.addToCart(userId, bookIdInt, quantityInt);
        httpSession.setAttribute("userCart", cartServices.getUserCart(userId));
        }catch (HibernateException ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=any");
        }
    }
}
