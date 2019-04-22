/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.servlets.admin;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.webproject.bookstore.controller.services.AdminServices;
import com.webproject.bookstore.controller.services.ServicesFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;

/**
 *
 * @author Menna Helmy
 */

public class PieChart extends HttpServlet{

     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            AdminServices adminServices = ServicesFactory.getAdminServices();
        int females = adminServices.getFemaleCount();
        int males = adminServices.getMaleCount();
        PrintWriter out = resp.getWriter();
        String text = "{}";
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(text, JsonObject.class);
        json.addProperty("females",females);
        json.addProperty("males",males);
        
        out.print(json);
        }catch (HibernateException ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=any");
        }
    }
    
    
    
}
