/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.servlets.admin;

import com.webproject.bookstore.controller.services.AdminServices;
import com.webproject.bookstore.controller.services.BookPageServices;
import com.webproject.bookstore.controller.services.HomeServices;
import com.webproject.bookstore.controller.services.ServicesFactory;
import com.webproject.bookstore.model.dal.dto.BookBean;
import com.webproject.bookstore.model.dal.hibrnate.entities.Offer;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;

/**
 *
 * @author Ibrahim
 */
public class UpdateBook extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminServices adminServices = ServicesFactory.getAdminServices();
        BookPageServices bookServices = ServicesFactory.getBookpageServices();
        int bookId = Integer.valueOf(req.getParameter("id"));
        String offer = req.getParameter("offer");
        int offerPercent = Integer.valueOf(offer.split(",")[0]);
        String offerDate = offer.split(",")[1];
        log(req.getParameter("price"));
        int quentity = Integer.valueOf(req.getParameter("quantity"));
        BookBean book = bookServices.getBookBean(bookId);
        BookBean updatedBook = new BookBean(req.getParameter("categ"), book.getOfferPercent(), req.getParameter("title"),
                req.getParameter("desc"), req.getParameter("author"), Double.valueOf(req.getParameter("price")),
                book.getImg(), book.getVisits(), book.getRate(), quentity,Integer.valueOf(req.getParameter("pages")),
                book.getSoldAmount(),quentity>0?true:false, book.getKeys(),book.getImgsCount());
        updatedBook.setOfferDate(offerDate);
        updatedBook.setOfferPercent(offerPercent);
        updatedBook.setBookId(bookId);
        try {
            adminServices.updateBook(updatedBook);
            req.setAttribute("bookUpdated","Book Has Updated Successully");
            req.getRequestDispatcher("admin/UpdateBook.jsp?true").forward(req, resp);
            //To change body of generated methods, choose Tools | Templates.
        } catch (ParseException ex) {
            resp.sendRedirect("error.html?ex=formating");
        } catch (HibernateException ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=any");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{AdminServices adminServices = ServicesFactory.getAdminServices();
        BookPageServices bookServices = ServicesFactory.getBookpageServices();
        HomeServices homeServices = ServicesFactory.getHomeServices();
        if (req.getParameter("selectedBook") == null) {
            List<BookBean> bookList = homeServices.getAllBooks(500);
            resp.setContentType("text/html");
            req.setAttribute("books", bookList);
            req.getRequestDispatcher("admin/bookToUpdate.jsp").forward(req, resp);
        } else {
            List<Offer> offers = adminServices.getAllOffers();
            int bookId = Integer.valueOf(req.getParameter("selectedBook"));
            BookBean book = bookServices.getBookBean(bookId);
            resp.setContentType("text/html");
            req.setAttribute("offers", offers);
            req.setAttribute("book", book);
            req.getRequestDispatcher("admin/UpdateBook.jsp").forward(req, resp);
        }
        }catch (HibernateException ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=any");
        }
    }

}
