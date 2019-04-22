/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.servlets.admin;

import com.webproject.bookstore.controller.services.AdminServices;
import com.webproject.bookstore.controller.services.HomeServices;
import com.webproject.bookstore.controller.services.ServicesFactory;
import com.webproject.bookstore.model.dal.dto.BookBean;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;

/**
 *
 * @author hd
 */
public class DeleteProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{HomeServices homeServices = ServicesFactory.getHomeServices();
        List<BookBean> allBooks = homeServices.getAllBooks(300);
        resp.setContentType("text/html");
        req.setAttribute("books", allBooks);
        req.getRequestDispatcher("admin/RemoveBook.jsp").forward(req, resp);
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
       try{
           String booksID[]= req.getParameterValues("selectedBooks");
       int ids[]=new int [booksID.length];
        for (int i = 0; i < booksID.length; i++) {
            ids[i]=Integer.parseInt(booksID[i]);
        }
        AdminServices adminServices=ServicesFactory.getAdminServices();
        adminServices.removeBooks(ids);
        doGet(req, resp);
        }catch (HibernateException ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=any");
        }
    }
    

}
