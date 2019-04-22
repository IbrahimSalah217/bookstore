/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.servlets.admin;

import com.webproject.bookstore.controller.services.AdminServices;
import com.webproject.bookstore.controller.services.ServicesFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
public class AddOffer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        try {
        int offerPercent = Integer.valueOf(request.getParameter("percent"));
        String offerDate = request.getParameter("date");
        log(offerDate);
        AdminServices adminServices = ServicesFactory.getAdminServices();
            adminServices.addOffer(offerPercent, offerDate);
            resp.getWriter().println("offer added successfully");
        } catch (ParseException ex) {
            resp.sendRedirect("error.jsp?ex=formating");
        } catch(HibernateException ex){
            resp.sendRedirect("error.jsp?ex=database");
        }catch (Exception ex){
            resp.sendRedirect("error.jsp?ex=any");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    }

    

}
