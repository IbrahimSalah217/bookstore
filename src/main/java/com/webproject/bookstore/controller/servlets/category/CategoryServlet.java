/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.servlets.category;

import com.webproject.bookstore.controller.services.ServicesFactory;
import com.webproject.bookstore.controller.services.Shop;
import com.webproject.bookstore.model.dal.dto.BookBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;

/**
 *
 * @author Ibrahim
 */
public class CategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Shop shopServices = ServicesFactory.getShopServices();
            String categoryName = request.getParameter("name");
            request.setAttribute("categoryName", categoryName);
            String priceRange = request.getParameter("price");
            String minPriceRange = priceRange.split("-")[0];
            int minPrice = Integer.valueOf(minPriceRange.substring(1, minPriceRange.length() - 1));
            String maxPriceRange = priceRange.split("-")[1];
            int maxPrice = Integer.valueOf(maxPriceRange.substring(2));
            String rateRange = request.getParameter("rate");
            log(rateRange);
            String minRateRange = rateRange.split("-")[0];
            int minRate = Integer.valueOf(minRateRange.substring(1, minRateRange.length() - 1));
            String maxRateRange = rateRange.split("-")[1];
            int maxRate = Integer.valueOf(maxRateRange.substring(2));
            log(minRate + " " + maxRate);
            String sorting = request.getParameter("sort");
            String orderType = sorting.split(" ")[0];
            boolean AsecSort = sorting.split(" ")[1].equals("A");
            String available = request.getParameter("available");
            boolean isAvailable = available.equals("true");
            List<BookBean> allfilterdBooks = shopServices.getFilteredBooks(orderType, AsecSort, categoryName, 50, minPrice, maxPrice, isAvailable, minRate, maxRate, 0);
            List<BookBean> topRatedBooks = shopServices.getTopBooks(categoryName, 9);
            response.setContentType("text/html");
            request.setAttribute("CategoryProducts", allfilterdBooks);
            request.setAttribute("topProducts", topRatedBooks);
            request.getRequestDispatcher("category_page.jsp").forward(request, response);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp?ex=any");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Shop shopServices = ServicesFactory.getShopServices();
            String categoryName = request.getParameter("name");
            request.setAttribute("categoryName", categoryName);
            List<BookBean> topRatedBooks = shopServices.getTopBooks(categoryName, 9);
            List<BookBean> allBooks = shopServices.getAllBooksinCategory(categoryName, 30);
            response.setContentType("text/html");
            request.setAttribute("topProducts", topRatedBooks);
            request.setAttribute("CategoryProducts", allBooks);
            request.getRequestDispatcher("category_page.jsp").forward(request, response);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp?ex=any");
        }
    }

}
