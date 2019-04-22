/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.servlets.home;

import com.webproject.bookstore.controller.services.AdminServices;
import com.webproject.bookstore.controller.services.Authentication;
import com.webproject.bookstore.controller.services.HomeServices;
import com.webproject.bookstore.controller.services.ServicesFactory;
import com.webproject.bookstore.controller.services.UserCartServices;
import com.webproject.bookstore.controller.services.WishListServices;
import com.webproject.bookstore.model.dal.dto.BookBean;
import com.webproject.bookstore.model.dal.dto.UserBean;
import com.webproject.bookstore.model.dal.hibrnate.entities.Category;
import com.webproject.bookstore.model.dal.hibrnate.entities.Offer;
import java.io.IOException;
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
public class UserHomeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AdminServices adminServices = ServicesFactory.getAdminServices();
            HomeServices homeServices = ServicesFactory.getHomeServices();
            WishListServices wishListServices = ServicesFactory.getWishListServices();
            Authentication authentication = ServicesFactory.getAuthenticationServices();
            HttpSession session = request.getSession(false);
            int userID = (Integer) session.getAttribute("userId");
            log("///////////////////////////////" + userID);
            UserBean userBean = authentication.getUserDetails(userID);
            List<BookBean> topRatedBooks = homeServices.getTopRated(50);
            List<BookBean> newArrivalsBooks = homeServices.getAllBooks(userID, 50);
            List<BookBean> bestSellerBooks = homeServices.getBestSeller(50);
            List<BookBean> OnSalesBooks = homeServices.getBooksWithOffers(12);
            List<BookBean> mostVisitedBooks = homeServices.getMostVisited(12);
            List<BookBean> wishList = wishListServices.getUserWishList(userID);
            List<BookBean> history = homeServices.getHistoryForUser(userID, 20);
            List<Offer> offers = adminServices.getAllOffers();
            List<Category> allCategories = homeServices.getAllCategories();
            response.setContentType("text/html");
            request.getServletContext().setAttribute("offers", offers);
            request.getServletContext().setAttribute("categories", allCategories);
            request.setAttribute("mostVisited", mostVisitedBooks);
            request.setAttribute("newItems", newArrivalsBooks);
            request.setAttribute("bestSeller", bestSellerBooks);
            request.setAttribute("topRated", topRatedBooks);
            request.setAttribute("onSale", OnSalesBooks);
            request.setAttribute("history", history);
            request.setAttribute("wishList", wishList);
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
            AdminServices adminServices = ServicesFactory.getAdminServices();
            HomeServices homeServices = ServicesFactory.getHomeServices();
            WishListServices wishListServices = ServicesFactory.getWishListServices();
            Authentication authentication = ServicesFactory.getAuthenticationServices();
            UserCartServices userCart = ServicesFactory.getUserCartServices();
            HttpSession session = request.getSession(false);
            int userID = (Integer) session.getAttribute("userId");
//        UserBean userBean = authentication.getUserDetails(userID);
            UserBean userBean = (UserBean) session.getAttribute("user");
            List<BookBean> topRatedBooks = homeServices.getTopRated(50);
            List<BookBean> newArrivalsBooks = homeServices.getAllBooks(userID, 50);
            List<BookBean> bestSellerBooks = homeServices.getBestSeller(50);
            List<BookBean> OnSalesBooks = homeServices.getBooksWithOffers(12);
            List<BookBean> mostVisitedBooks = homeServices.getMostVisited(12);
            List<BookBean> wishList = wishListServices.getUserWishList(userID);
            List<BookBean> history = homeServices.getHistoryForUser(userID, 20);
            List<Offer> offers = adminServices.getAllOffers();
            List<Category> allCategories = homeServices.getAllCategories();
            response.setContentType("text/html");
            request.getServletContext().setAttribute("offers", offers);
            request.getServletContext().setAttribute("categories", allCategories);
            request.setAttribute("mostVisited", mostVisitedBooks);
            request.setAttribute("newItems", newArrivalsBooks);
            request.setAttribute("bestSeller", bestSellerBooks);
            request.setAttribute("topRated", topRatedBooks);
            request.setAttribute("onSale", OnSalesBooks);
            request.setAttribute("history", history);
            request.setAttribute("wishList", wishList);
//        session.setAttribute("userCart", userCart.getUserCart(userID));
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp?ex=any");
        }

    }

}
