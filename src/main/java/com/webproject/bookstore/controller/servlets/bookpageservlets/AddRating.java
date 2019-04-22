/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.servlets.bookpageservlets;

import com.webproject.bookstore.controller.services.AdminServices;
import com.webproject.bookstore.controller.services.BookPageServices;
import com.webproject.bookstore.controller.services.ServicesFactory;
import com.webproject.bookstore.model.dal.dto.BookBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AddRating extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Integer, List<String>> reviewsMap = new HashMap<>();
        HttpSession session = request.getSession(false);
        
        int rate = Integer.valueOf(request.getParameter("rate"));
        int bookId = Integer.valueOf(request.getParameter("bookId"));
        BookPageServices bookServices = ServicesFactory.getBookpageServices();
        AdminServices adminServices = ServicesFactory.getAdminServices();
        BookBean bookBean = bookServices.getBookBean(bookId);
        bookBean.setRate(rate);
        bookBean.setReviews(bookBean.getReviews() + 1);
        if (session != null) {
            List<String> comments = new ArrayList<>();
            comments.add(request.getParameter("username"));
            comments.add(request.getParameter("comment"));
            comments.add(request.getParameter("rate"));
            reviewsMap.put(bookId,comments);
            session.setAttribute("reviewsMap", reviewsMap);
        }
        try {
            adminServices.updateBook(bookBean);
            response.getWriter().println("Review added successfully");
        } catch (ParseException ex) {
            response.sendRedirect("error.html?ex=formating");
        }catch (HibernateException ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp?ex=any");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
