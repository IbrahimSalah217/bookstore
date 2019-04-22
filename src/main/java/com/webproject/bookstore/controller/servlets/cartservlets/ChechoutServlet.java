
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.servlets.cartservlets;

import com.webproject.bookstore.controller.services.Authentication;
import com.webproject.bookstore.controller.services.OrderServices;
import com.webproject.bookstore.controller.services.ServicesFactory;
import com.webproject.bookstore.controller.services.UserCartServices;
import com.webproject.bookstore.model.dal.dto.CartBean;
import com.webproject.bookstore.model.dal.dto.OrderBean;
import com.webproject.bookstore.model.dal.dto.UserBean;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ChechoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{UserCartServices cartServices = ServicesFactory.getUserCartServices();
        OrderServices orderServices = ServicesFactory.getOrderServices();
        Authentication userService = ServicesFactory.getAuthenticationServices();
        HttpSession httpSession = req.getSession(false);
        int userId = (int) httpSession.getAttribute("userId");
        List<CartBean> userCart = cartServices.getUserCart(userId);
        if(cartServices.checkOut(userCart,userId)){
            List<OrderBean> userOrders = orderServices.getUserOrder(userId);
            req.setAttribute("userOrders", userOrders);
            httpSession.setAttribute("user", userService.getUserDetails(userId));
            RequestDispatcher rd = req.getRequestDispatcher("order_page.jsp");
            rd.forward(req, resp);
        }else{
            req.setAttribute("error", "limit");
            RequestDispatcher rd = req.getRequestDispatcher("LoadCartServlet");
            rd.forward(req, resp);
        }}catch (HibernateException ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=any");
        }
    }
}