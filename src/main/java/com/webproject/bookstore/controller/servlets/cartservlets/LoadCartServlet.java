/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.servlets.cartservlets;

import com.webproject.bookstore.controller.services.HomeServices;
import com.webproject.bookstore.controller.services.ServicesFactory;
import com.webproject.bookstore.controller.services.UserCartServices;
import com.webproject.bookstore.model.dal.dto.BookBean;
import com.webproject.bookstore.model.dal.dto.CartBean;
import com.webproject.bookstore.model.dal.dto.UserBean;
import java.io.IOException;
import java.util.List;
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
public class LoadCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{//UserCartServices cartServices = ServicesFactory.getUserCartServices();
        HomeServices homeServices = ServicesFactory.getHomeServices();
        HttpSession httpSession = req.getSession(false);
        //int userId = (int) httpSession.getAttribute("userId");
        List<CartBean> userCart = (List<CartBean>) httpSession.getAttribute("userCart");
        //List<CartBean> userCart = cartServices.getUserCart(userId);
        double total=0;
        for (CartBean cartBean : userCart) {
            if(cartBean.getBookBean().isAvailable())
                total+=cartBean.getTotal();
            
        }
        List<BookBean> OnSalesBooks = homeServices.getBooksWithOffers(12);
        //httpSession.setAttribute("userCart", userCart);
        req.setAttribute("onSale", OnSalesBooks);
        req.setAttribute("totalPrice", total);
        RequestDispatcher rd = req.getRequestDispatcher("cart_page.jsp");
        rd.forward(req, resp);
        }catch (HibernateException ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=any");
        }
    }
}
