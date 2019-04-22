/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.servlets.home;

import com.webproject.bookstore.controller.services.AdminServices;
import com.webproject.bookstore.controller.services.HomeServices;
import com.webproject.bookstore.controller.services.ServicesFactory;
import com.webproject.bookstore.controller.services.Shop;
import com.webproject.bookstore.model.dal.dto.BookBean;
import com.webproject.bookstore.model.dal.hibrnate.entities.Admin;
import com.webproject.bookstore.model.dal.hibrnate.entities.Category;
import com.webproject.bookstore.model.dal.hibrnate.entities.Offer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;

/**
 *
 * @author Ibrahim
 */
public class HomeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            
            System.out.println("com.webproject.bookstore.controller.servlets.home.HomeServlet.doGet()"
                    + "//////////////////////////////////////////////////////////////////////////////");
        AdminServices adminServices = ServicesFactory.getAdminServices();
        HomeServices homeServices = ServicesFactory.getHomeServices();
        List<BookBean> topRatedBooks = homeServices.getTopRated(50);
        List<BookBean> newArrivalsBooks = homeServices.getNewArrivals(300);
        List<BookBean> AllBooks = homeServices.getAllBooks(300);
        List<BookBean> bestSellerBooks = homeServices.getBestSeller(50);
        List<BookBean> OnSalesBooks = homeServices.getBooksWithOffers(12);
        List<BookBean> mostVisitedBooks = homeServices.getMostVisited(12);
        List<Category> allCategories = homeServices.getAllCategories();
        List<Offer> offers = adminServices.getAllOffers();
        response.setContentType("text/html");
        request.getServletContext().setAttribute("offers", offers);
        request.getServletContext().setAttribute("categories", allCategories);
        request.setAttribute("mostVisited", mostVisitedBooks);
        request.setAttribute("newItems", newArrivalsBooks);
        request.setAttribute("bestSeller", bestSellerBooks);
        request.setAttribute("topRated", topRatedBooks);
        request.setAttribute("onSale", OnSalesBooks);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        }catch (HibernateException ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp?ex=any");
        }
        
    }

}
