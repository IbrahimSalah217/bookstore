/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.servlets.bookpageservlets;

import com.webproject.bookstore.controller.services.BookPageServices;
import com.webproject.bookstore.model.dal.dto.BookBean;
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
public class LoadBookPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{BookPageServices bookPageServices = new BookPageServices();
        int bookId = Integer.parseInt(req.getParameter("id"));
        bookPageServices.updateBookVisits(bookId);
        HttpSession session = ((HttpServletRequest) req).getSession(false);
        if (session != null) {
            UserBean user = (UserBean) session.getAttribute("user");
            if (user != null) {
                bookPageServices.updateUserVisitBook(user.getUserId(), bookId);
            }
        }
        BookBean bookBean = bookPageServices.getBookBean(bookId);
        List<BookBean> relatedBooks = bookPageServices.getRelatedBooks(bookId);

        req.setAttribute("selectedProduct", bookBean);
        req.setAttribute("relatedProducts", relatedBooks);
        RequestDispatcher rd = req.getRequestDispatcher("product_detail_page.jsp");
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
